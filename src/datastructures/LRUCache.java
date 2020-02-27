package datastructures;

import java.util.*;

public class LRUCache {
    public int pagefaults(int[]arr,int cap){

        HashSet<Integer>hashset=new HashSet<>(cap);
        HashMap<Integer,Integer>hashmap=new HashMap<>(arr.length);

        HashMap<Double,Integer>ashmap=new HashMap<>();

        int page_faults=0;
        int i=0;

        while(i<arr.length){
            System.out.println(hashset.size());
           if(hashset.contains(arr[i])){
               hashmap.put(arr[i],i);
               i++;
           }
           else if(hashset.size()<cap){
               page_faults++;
               hashset.add(arr[i]);
               hashmap.put(arr[i],i);
               i++;
           }
           else{
               int min=Integer.MAX_VALUE;
               int temp=0;
               for(int j:hashset){
                   if(hashmap.get(j)<min){
                       min=hashmap.get(j);
                       temp=j;
                   }
               }
               page_faults++;
               hashset.remove(temp);
               hashset.add(arr[i]);
               hashmap.put(arr[i],i);
               i++;
           }


        }

        return page_faults;



    }
    public static void main (String args[])
    {
        LRUCache lru=new LRUCache();

      // int pages[]={7,0,1,2,0,3,0,4,2,3,0,3,2};
        int pages[]={1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int pagecapacity=3;
        //int pagecapacity=4;
        int result=lru.pagefaults(pages,pagecapacity);

        System.out.println(result);


    }
}
