package datastructures;

import java.util.ArrayList;
import java.util.List;

public class bankerheights {
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

        quicksort(heights, 0,heights.size()-1,infronts);
        System.out.println(heights.get(0)+" "+infronts.get(0));
        SegmentTree root = new SegmentTree(heights.get(0));

        for(int i=1;i<heights.size();i++){
            root.insert(heights.get(i), infronts.get(i));
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        root.inorder(output);
        return output;
    }
    public static void main(String args[]) {
        bankerheights bh=new bankerheights();
        ArrayList<Integer> heights = new ArrayList<Integer>();
        ArrayList<Integer> infronts = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        heights.add(6);
        heights.add(5);
        heights.add(4);
        heights.add(3);
        heights.add(2);
        heights.add(1);


        infronts.add(2);
        infronts.add(2);
        infronts.add(3);
        infronts.add(0);
        infronts.add(1);
        infronts.add(0);
        System.out.println(heights.get(0)+" "+infronts.get(0));
        result=bh.order(heights,infronts);

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }

    public void quicksort(ArrayList<Integer> ar, int start, int end, ArrayList<Integer> infronts){
        if(start<end){
            int middle = partition(ar,start, end, infronts);
            quicksort(ar,start,middle-1,infronts);
            quicksort(ar,middle+1, end,infronts);
        }
    }

    public int partition(ArrayList<Integer> ar, int start, int end, ArrayList<Integer> infronts){
        int index = start-1;
        int pivot = ar.get(end);
        int traverse = start;
        while(traverse<end){
            if(ar.get(traverse)<=pivot){
                index++;
                swap(ar, infronts, traverse, index);
            }
            traverse++;
        }
        index++;
        swap(ar, infronts, traverse, index);
        return index;
    }

    public static void swap(ArrayList<Integer> ar, ArrayList<Integer> offset, int traverse, int index){
        int temp = ar.get(traverse);
        ar.set(traverse, ar.get(index));
        ar.set(index,temp);

        temp = offset.get(traverse);
        offset.set(traverse, offset.get(index));
        offset.set(index,temp);
    }


    static class SegmentTree{
        SegmentTree left,right;
        int data,value;

        public SegmentTree(int data){
            this.data = data;
            this.value = 1;
        }

        public void inorder(ArrayList<Integer> output){
            if(this.left != null){
                this.left.inorder(output);
            }
            output.add(this.data);
            if(this.right != null){
                this.right.inorder(output);
            }
        }

        public void insert(int data, int value){
//			SegmentTree newNode = new SegmentTree(data);
            if(value < this.value){
                this.value+=1;
                if(this.left != null){
                    this.left.insert(data, value);
                }else{
                    SegmentTree newNode = new SegmentTree(data);
                    this.left = newNode;
                }
            }else{
                if(this.right != null){
                    this.right.insert(data,value - this.value);
                }else{
                    SegmentTree newNode = new SegmentTree(data);
                    this.right = newNode;
                }
            }
        }
    }



}