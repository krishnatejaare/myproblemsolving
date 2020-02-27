package datastructures;

public class repeatedSubStringCheck {

  public boolean rsr(String str) {
    for (int i = str.length() / 2; i >= 1; i--) {
      if(str.length() % i == 0){
        StringBuilder tempStr = new StringBuilder();
        String partStr = str.substring(0, i);
        for (int j = 0; j < str.length() / i; j++) {
          tempStr.append(partStr);
        }
        if(tempStr.toString().equals(str)){
          return true;
        }
      }
    }
    return false;
  }
  public static void main(String[] args) {
      repeatedSubStringCheck r = new repeatedSubStringCheck();
      System.out.println(r.rsr("ababab"));

  }

}
