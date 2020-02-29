package datastructures;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueue {

  private void initRecentQueue() {
    recentNotebookQueue = RecentNotebookQueue.getInstance();
    recentNotebookQueue.open();
    recentNotebookQueue.initRefs(this);
  }

  public class RecentNotebookQueue {

    private static final Logger LOG = LoggerFactory.getLogger(RecentNotebookQueue.class);
    private java.util.concurrent.BlockingQueue<Map<String,NotebookInfo>> queue;
    private static RecentNotebookQueue INSTANCE;
    private boolean isExecutorStarted = false;
    private ExecutorService executor;
    private Integer capacity;
    private final Object recentMapFileLock = new Object();
    private NotebookServer notebookServer;

    public RecentNotebookQueue(){
      queue = new LinkedBlockingQueue<>();
    }

    public static RecentNotebookQueue getInstance() {
      if (INSTANCE == null) {
        synchronized (RecentNotebookQueue.class) {
          if (INSTANCE == null) {
            LOG.info("RecentNotebookQueue instance created");
            INSTANCE = new RecentNotebookQueue();
          }
        }
      }
      return INSTANCE;
    }

    public void initRefs(NotebookServer notebookServerRef){
      notebookServer = notebookServerRef;
    }


    public void addToQueue(String userName, String action, int capacity, NotebookInfo recentNotebookInfo){
      this.capacity = capacity;
      Map<String,NotebookInfo> recentNotebookInfoMap = new HashMap<>();
      String key = userName + "#" + action;
      recentNotebookInfoMap.put(key, recentNotebookInfo);
      this.queue.add(recentNotebookInfoMap);
      LOG.info("Recent Notebooks Queue Size: {}", queue.size());
    }


    /**
     * Method to start or begin the RecentNotebookQueue.
     */
    public void open() {
      if (isExecutorStarted)
        return;
      synchronized (recentMapFileLock) {
        if (!isExecutorStarted) {
          executor = Executors.newSingleThreadExecutor();
          executor.submit(new RecentNotebookQueueRunnable());
          isExecutorStarted = true;
          LOG.info("RecentNotebookQueueRunnable has started successfully!");
        }
      }
    }

    private class RecentNotebookQueueRunnable implements Runnable {

      public void run() {
        while (true){
          try {
            LOG.info("Queue Size before update: {}", queue.size());
            Map<String,NotebookInfo> recentNotebookInfoMap = queue.take();
            for (Map.Entry<String, NotebookInfo> entry : recentNotebookInfoMap.entrySet()) {
              String userName = entry.getKey().split("#")[0];
              String action = entry.getKey().split("#")[1];
              if (action.equals("remove")) {
                removeRecentNotebooks(entry.getValue().getNoteId(), userName);
              } else {
                updateRecentNotebooks(userName, entry.getValue());
              }
            }
            LOG.info("Queue Size after update: {}", queue.size());
          }catch(Exception ex){
            LOG.error("Suppressing error which occurred while processing a RecentNotebookQueue: {}", ex);
          }

        }
      }

      private void updateRecentNotebooks(String userName, NotebookInfo recentNotebookInfo){
        try {

          LOG.debug("Starting the recent notebook transaction, User: {}, NoteId: {} - timestamp: {}", userName, recentNotebookInfo.getNoteId(), System.currentTimeMillis());
          Map<String, LinkedHashMap<String, NotebookInfo>> userRecentNotebooksMap = notebookServer.getUserNotebooksMap("RECENT");
          LinkedHashMap<String, NotebookInfo> tmpStoreFromJsonFile = new LinkedHashMap<>();
          if (userRecentNotebooksMap.containsKey(userName)) {
            tmpStoreFromJsonFile = userRecentNotebooksMap.get(userName);
          }
          LinkedHashMap<String, NotebookInfo> recentNotebooksMap = new LinkedHashMap<String, NotebookInfo>(tmpStoreFromJsonFile) {
            public boolean removeEldestEntry(Map.Entry<String, NotebookInfo> eldest) {
              return size() > capacity;
            }
          };
          recentNotebooksMap.remove(recentNotebookInfo.getNoteId());
          recentNotebooksMap.put(recentNotebookInfo.getNoteId(), recentNotebookInfo);
          userRecentNotebooksMap.put(userName, new LinkedHashMap<>(recentNotebooksMap));
          USER_RECENT_NOTEBOOKS_MAP.startTransaction(SharedLockFactory.userNotebookMapLock);
          USER_RECENT_NOTEBOOKS_MAP.update(userRecentNotebooksMap);
        } catch(Exception e){
          LOG.error("Exception in computing recent notebook list of User: {} NoteId: {}, Error: {}", userName, recentNotebookInfo.getNoteId(), e.getMessage());
        } finally {
          USER_RECENT_NOTEBOOKS_MAP.endTransaction(SharedLockFactory.userNotebookMapLock);
          LOG.debug("Ending the recent notebook transaction, User: {}, NoteId: {} - timestamp: {}", userName, recentNotebookInfo.getNoteId(), System.currentTimeMillis());
        }
      }

      private void removeRecentNotebooks(String noteId, String user) {
        try {

          LOG.debug("Starting to remove recent transaction, User: {}, NoteId: {} - timestamp: {}", user, noteId, System.currentTimeMillis());
          Map<String, LinkedHashMap<String, NotebookInfo>> userRecentNotebooksMap = notebookServer.getUserNotebooksMap("RECENT");

          if (!userRecentNotebooksMap.isEmpty()) {
            LinkedHashMap<String, NotebookInfo> recentNotebooksMap;
            for (Map.Entry<String, LinkedHashMap<String, NotebookInfo>> entry : userRecentNotebooksMap.entrySet()) {
              recentNotebooksMap = entry.getValue();
              recentNotebooksMap.remove(noteId);
              LOG.debug("Removed the recent notebook, User: {}, NoteId: {}", user, noteId);
              userRecentNotebooksMap.put(entry.getKey(), recentNotebooksMap);
            }
            USER_RECENT_NOTEBOOKS_MAP.startTransaction(SharedLockFactory.userNotebookMapLock);
            USER_RECENT_NOTEBOOKS_MAP.update(userRecentNotebooksMap);
          }
        } catch (Exception e) {
          LOG.error("Error in computing to remove recent notebook list {}, User: {}, NoteId: {}", e.getMessage(), user, noteId);
        } finally {
          LOG.debug("Ending the remove recent transaction, User: {}, NoteId: {} - timestamp: {}", user, noteId, System.currentTimeMillis());
          USER_RECENT_NOTEBOOKS_MAP.endTransaction(SharedLockFactory.userNotebookMapLock);
        }
      }

    }



  }



}
