package datastructures;

import java.util.ArrayList;
import java.util.List;

public class ListToArray {
  private static List<Integer> result=new ArrayList<>();
  public static void main(String[]args){
    result.stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
