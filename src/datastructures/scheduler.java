package datastructures;

import java.text.SimpleDateFormat;
import java.util.Date;


public class scheduler {

  public static void main (String args[]) {
    int[] input = {1, 2, 3, 4, 5, 6};
    int[] secondinput = {1, 3, 4, 5, 6};
    int xor = 0;
    for (int i : input) {
      xor ^= i;
    }
    for (int x : secondinput) {
      xor ^= x;
    }
    System.out.println(xor);

    for (char c : ("" + (2 + 1)).toCharArray()) {
      System.out.println(c);
    }
  }
}
