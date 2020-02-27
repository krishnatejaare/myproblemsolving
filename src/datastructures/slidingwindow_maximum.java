package datastructures;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class slidingwindow_maximum {

    static int[] max_in_sliding_window(int[] arr, int w) {
//        int [] ans = new int [arr.length - w + 1];
//        Deque<Integer> d = new ArrayDeque<>();
//
//        for(int i = 0; i < arr.length; i++){
//            while (!d.isEmpty() && arr[i] > arr[d.getLast()]) {
//                d.removeLast();
//            }
//            d.addLast(i);
//            if(i >= w - 1){
//                while(d.peekFirst() < i-w+1){
//                    d.pollFirst();
//                }
//                ans[i - w + 1] = arr[d.peekFirst()];
//            }
//        }
//
//
//        return ans;

        if(arr.length==0) return arr;
        int [] ans = new int [arr.length - w + 1];
        Deque<Integer> d = new ArrayDeque<>();

        for(int i = 0; i < arr.length; i++){

            while (!d.isEmpty() && arr[i] > arr[d.getLast()]) {
                d.removeLast();
            }
            d.addLast(i);
            if(i >= w - 1){
                while(d.getFirst() < i-w+1){
                    d.removeFirst();
                }
                ans[i - w + 1] = arr[d.getFirst()];
            }
        }


        return ans;
    }

     ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;

    public  void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])                           deq.removeLast();
    }

    public  int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public static void main(String[] args){
        //int[]arr={9,4,3,-3,5,3,6,7};
        int [] arr = {10,40,20,15,30,85,99,13};
        int w=3;
        slidingwindow_maximum S = new slidingwindow_maximum();
        int[]res = max_in_sliding_window(arr, w);

        for(int res_i = 0; res_i < res.length; res_i++) {
            System.out.print(String.valueOf(res[res_i])+" ");
        }

        char s='1';
        int si=s-'0';
        System.out.println();
        System.out.println(si);
    }

}

