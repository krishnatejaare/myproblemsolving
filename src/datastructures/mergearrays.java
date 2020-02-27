package datastructures;

public class mergearrays {

    public int[] merger_first_into_second(int[] arr1, int[] arr2) {

        int small=arr1.length;
        int big=arr2.length;
        int j=arr1.length-1;
        int i=arr1.length-1;
        int count=arr2.length-1;
        while(i>=0 && j>=0){
            if(arr1[i]>arr2[j]){
                arr2[count]=arr1[i];
                count--;
                i--;
            }
            else{
                arr2[count]=arr2[j];
                count--;
                j--;
            }
        }

        while(i>=0){
            arr2[count]=arr1[i];
            count--;
            i--;
        }
        while(j>=0){
            arr2[count]=arr2[j];
            count--;
            j--;
        }


        return arr2;
    }



    public static void main (String args[]) {

        mergearrays ma=new mergearrays();
        int []arr1={2,3,8};
        int []arr2={11,15,19,0,0,0};
        int[]result=ma.merger_first_into_second(arr1,arr2);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+",");
        }


    }
}
