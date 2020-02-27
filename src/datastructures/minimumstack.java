package datastructures;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class minimumstack {
    static int[] min_stack(int[] operations) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();

        for(int i =0; i < operations.length; i++){
            //Push
            if(operations[i] >= 1){
                stack.push(operations[i]);

                if(minStack.isEmpty() || operations[i] <= minStack.peek())
                    minStack.push(operations[i]);
            }//pop
            else if(operations[i] == -1){

                if(!stack.isEmpty()){
                    int no =  stack.peek();
                    stack.pop();

                    if(!minStack.isEmpty() && minStack.peek() == no)
                        minStack.pop();
                }


            }//return min
            else if(operations[i] == 0){

                if(!minStack.isEmpty())
                    ans.add(minStack.peek());
                else
                    ans.add(-1);
            }
        }

        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    public static void main(String[] args){
        int[] operations = {5,10,-1,0};


        int[] res = min_stack(operations);

        for (int resItr = 0; resItr < res.length; resItr++) {
            System.out.println(String.valueOf(res[resItr]));
        }


    }
}
