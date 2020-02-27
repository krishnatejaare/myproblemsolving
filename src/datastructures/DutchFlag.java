package datastructures;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class DutchFlag {
    public char[] dutch_flag_sort(String balls) {

        int red_index = 0;
        int blue_index = balls.length() - 1;
        int current_index = 0;

        char[] array = balls.toCharArray();

        while (current_index <= blue_index) {
            if (array[current_index] == 'R') {
                swap(array, current_index, red_index);
                current_index++;
                red_index++;
            }
            else if(array[current_index] == 'B') {
                    swap(array, current_index, blue_index);
                    blue_index--;
                }
             else{
                    current_index++;
                }
            }

            return array;


        }


        public void swap ( char[] arr, int current, int target){
            char temp = arr[current];
            arr[current] = arr[target];
            arr[target] = temp;
        }

        public static void main (String args[])
        {
            DutchFlag d=new DutchFlag();
            String balls="GBGGRBRG";
            char[] result=d.dutch_flag_sort(balls);
            for(int i=0;i<result.length;i++){
                System.out.print(result[i]+",");
            }


        }
    }

