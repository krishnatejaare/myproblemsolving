package datastructures;

import java.time.LocalDate;
import java.util.HashMap;

public class isomorphicStrings {
public static boolean mor(String s, String t){

  if(s==null || t==null ||s.length()!=t.length())
    return false;

  int[] m1 = new int[256];
  int[] m2 = new int[256];
  int n=s.length();
  for(int i=0; i< n;i++){
    char c1 = s.charAt(i);
    char c2 = t.charAt(i);
    if(m1[c1]!= m2[c2]){
      return false;
    }
    m1[c1]=i+1;
    m2[c2]=i+1;

  }
  return true;
}
  public static void main (String args[])
  {
    String s="foo";
    String t="baa";
System.out.println(mor(s,t));
    LocalDate localDate = LocalDate.now();
    LocalDate yesterday = localDate.minusDays(1);
    String fromDate = yesterday.toString();
    String toDate = localDate.toString();
    System.out.println("After Resetting fromDate and toDate {}, {}" + fromDate + "$$$" + toDate);
    HashMap<String,String>hashmap =new HashMap<>();
    hashmap.put("cron","");
    if(hashmap.get("cron")=="") {
      System.out.println("newapple"+hashmap.get("cron")+"apple");
    }
    else {
      System.out.println("apple" + hashmap.get("cron") + "apple");
    }

  }

}
