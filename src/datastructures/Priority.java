package datastructures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Priority {
  public static void main(String[]args){
    PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);
    heap.add(5);
    heap.add(4);
    System.out.println(heap.peek());
    if(heap.size()>1){
      heap.remove();
    }
    System.out.println(heap.peek());
    //for(int i:heap){

    //}

//    int a = 'z'-0;
//    System.out.println((char)a);
//    Map<String,Integer> maper = new HashMap<>();
//    maper.put("Krishna",1);
//    String apple =null;
//    if(maper.containsKey(apple)) {
//      System.out.println("if");
//    } else {
//      System.out.println("else");
//    }

    String su="";
    if(!su.isEmpty()){
      System.out.println("if");
    } else {
      System.out.println("else");
    }

    String out = "res10: org.apache.spark.sql.expressions.UserDefinedFunction = UserDefinedFunction(<function1>,StringType,Some(List(StringType)))\\nBorder\\n+--------------------------+-----------+\\n|UDF:uppercase(DEVICE_CODE)|DEVICE_CODE|\\n+--------------------------+-----------+\\n|IPAD6,7                   |iPad6,7    |\\n|IPAD11,3                  |iPad11,3   |\\n|IPHONE10,2                |iPhone10,2 |\\n|IPHONE10,3                |iPhone10,3 |\\n|IPHONE10,3                |iPhone10,3 |\\n|IPHONE10,3                |iPhone10,3 |\\n|IPHONE10,3                |iPhone10,3 |\\n|IPHONE10,3                |iPhone10,3 |\\n|IPHONE10,3                |iPhone10,3 |\\n|IPHONE10,3                |iPhone10,3 |\\n+--------------------------+-----------+\\n\\n";
    System.out.println(out.split("Border")[0]);
    System.out.println(out.split("Border")[1]);
    System.out.println(out.split("Border")[0].replace("\\n",""));
    String req=out.split("Border")[1];
    System.out.println(out.split("Border")[1].substring(2,req.length()));

//    String in = "This is my text.\\n\\nAnd here is a new line";
//    System.out.println(in);
//
//    out = in.replaceAll("[\\t\\n\\r]+"," ");
//    System.out.println(out);

  }
}
