package datastructures;

import java.util.*;

//shortest distances from one particular node to all the nodes in the graphs
public class Dijkstra {
    public int[] graphDistances(int[][] g, int s) {
        int[] dist = new int[g.length];
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(s, 0));
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.remove();
            if (!visited.add(entry.getKey())) continue;
            dist[entry.getKey()] = entry.getValue();
            for (int i = 0; i < g.length; i++) {
                if (g[entry.getKey()][i] != -1) {
                    pq.add(new AbstractMap.SimpleEntry<>(i, entry.getValue() + g[entry.getKey()][i]));
                }
            }
        }
        return dist;
    }

    public static void main (String args[])
    {
        Dijkstra d=new Dijkstra();
        //int [][]g={{-1,3,2},{2,-1,0},{-1,0,-1}};
        int [][]g={{-1,3,4},{2,-1,0},{-1,0,-1}};
        int s=0;
        int[]result=d.graphDistances(g,s);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }


}
