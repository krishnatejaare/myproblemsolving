package datastructures;

public class QuickSort {

    public int partition(int arr[],int low,int high){
        int pivot=arr[high];
        int j=low-1;

        for(int i=low;i<high;i++){
            if(arr[i]<=pivot){
                j++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[high];
        arr[high]=arr[j+1];
        arr[j+1]=temp;

        return j+1;
    }

    public void sort(int arr[],int low,int high){
        if(low<high){
            int pi=partition(arr,low,high);
            sort(arr,low,pi-1);
            sort(arr,pi+1,high);
        }
    }

    public void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
    }

    public static void main(String[]args){
        int[]arr={10,3,-4,1,-6,9,3,-4,1};
        int n=arr.length;
        QuickSort ob=new QuickSort();
        ob.sort(arr,0,n-1);
        ob.printArray(arr);



    }

}





