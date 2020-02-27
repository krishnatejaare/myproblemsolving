package datastructures;

import java.util.*;

public class MergeSort {

    public void merge(int[]arr,int low,int mid, int high){
        int n1=mid-low+1;
        int n2=high-mid;

        int left[]=new int[n1];
        int right[]=new int[n2];

        for(int i=0;i<n1;i++){
            left[i]=arr[low+i];
        }

        for(int j=0;j<n2;j++){
            right[j]=arr[mid+1+j];
        }

        int i=0,j=0;
        int k=low;

        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
            }
            k++;

        }

        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }



    }

    public void sort(int[]arr,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);

            merge(arr,low,mid,high);

        }
    }

    public void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }

    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        MergeSort ob = new MergeSort();
        //ob.sort(arr, 0, arr.length-1);
        //ob.printArray(arr);



        /////above is original merge sort program.


//        HashMap<String,String> map=new HashMap<String,String>();
//        HashMap<String,String> mapcount=new HashMap<String,String>();
//
//        HashSet<String>set=new HashSet<String>();
//        StringBuilder finalresult=new StringBuilder();
//       // String ar[]= {"key1 abcd","key2 zzz","key1 hello","key3 world","key1 hello"};
//        String ar[]={"akshay q","akshay qq","akshay qqq","akshay qqqq"};
//
//        for(String p:ar){
//            String s[]=p.split(" ");
//            int count=1;
//            if(map.containsKey(s[0])){
//                int quo=Integer.parseInt(mapcount.get(s[0]));
//                int qu=quo+1;
//                mapcount.put(s[0],Integer.toString(qu));
//
//
//                String b=map.get(s[0]);
//
//                if(b.compareTo(s[1])<0){
//                    map.put(s[0],s[1]);
//                }
//                if(b.compareTo(s[1])>0){
//                    map.put(s[0],b);
//                }
//            }
//            else{
//
//                map.put(s[0],s[1]);
//                mapcount.put(s[0],Integer.toString(count));
//            }
//
//        }
//
//
//        for(Map.Entry<String, String> entry1 : map.entrySet()){
//        String key = entry1.getKey();
//        String value1 = entry1.getValue();
//        String value2 = mapcount.get(key);
//            StringBuilder result=new StringBuilder();
//            result.append(key).append(":").append(value2).append(",").append(value1).append(System.lineSeparator());
//            set.add(result.toString());
//    }
//
//        for(String s:set){
//            finalresult.append(s);//            System.out.println(s);
//        }

       // int subarraycount=arr.length;
        int arrayis[][] = { {1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}} ;
        int b[]=arrayis[0];

        System.out.println(b[2]);
        int count[]=new int[3];
        count[0]++;


        List<Integer> result=new ArrayList<Integer>();
        result.add(1);
        result.toArray(new Integer[result.size()]);
        System.out.print(count[0]);




//        if(map.containsKey(s[0])){
//            String b=map.get(s[0]);
//            StringBuilder finalresult=new StringBuilder();
//            if(b.compareTo(s[1])<0){
//                map.put(s[0],s[1]);
//            }
//            if(b.compareTo(s[1])>0){
//                map.put(s[0],b);
//            }
//        }
//        else{
//            map.put(s[0],s[1]);
//        }







    }
}
