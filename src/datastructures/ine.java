package datastructures;

import java.util.ArrayList;
import java.util.List;

class ine {
  public static boolean solution(String str) {

    List<Character> list = new ArrayList<Character>();
    for (int i = 0; i < str.length(); i++) {
      if (list.contains(str.charAt(i)))
        list.remove((Character) str.charAt(i));
      else
        list.add(str.charAt(i));
    }

    if (str.length() % 2 == 0 && list.isEmpty()
        || (str.length() % 2 == 1 && list.size() == 1))
      return true;
    else
      return false;

  }
  public static String solution2(String angles) {
    int openCount = 0;
    int additionalLeadingOpenTags = 0;
    for (int i=0;i<angles.length();i++) {
      if (angles.charAt(i) == '>') {
        if (openCount == 0) {
          additionalLeadingOpenTags++;
        } else {
          openCount--;
        }
      } else {
        openCount++;
      }
    }
    String result =null;
    StringBuffer s = new StringBuffer();
    for (int i=0;i<additionalLeadingOpenTags;i++) {
        s.append('<');
    }
    s.append(angles);
    for (int i=0;i<openCount;i++) {
      s.append('>');
    }
    return s.toString();

  }

  public static void main(String[] args){
    System.out.println(solution2("><<><"));
  }
}

