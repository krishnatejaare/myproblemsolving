package datastructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class wordbreak {

        /*
         * Given a string "allinto" need to break into all possible combination of words present in given dictionary of words
         *
         * The function accepts STRING_ARRAY dictionary as parameter and the original
         * string txt on which segmentation is to be performed. The function returns the
         * list of all possible segmentation arrangements.
         */

        public  List<String> solver(int dictionaryCount, List<String> dictionary, String txt) {
            // Write your code here
            return wordBreakDPV2(txt, new HashSet<>(dictionary), new HashMap<>());
        }

        public List<String> wordBreakDPV2(String s, Set<String> dictionary, Map<String, List<String>> DP) {
            for (int i = s.length() - 1; i >= 0; i--) {
                String suffix = s.substring(i);
                List<String> result = new ArrayList<>();

                for (String d : dictionary) {
                    if (suffix.startsWith(d)) {
                        String remainingS = suffix.substring(d.length());
                        if (remainingS.isEmpty()) {
                            result.add(d);
                        } else {
                            List<String> phrases = DP.get(remainingS);
                            for (String phrase : phrases)
                                result.add(d + " " + phrase);
                        }
                    }
                }
                DP.put(suffix, result);
            }
            return DP.get(s);
        }



        public static void main(String[] args) throws IOException {

            wordbreak w=new wordbreak();
            String s="allinto";
            List<String> res = new ArrayList<>();
            List<String> resu = new ArrayList<>();
            res.add("all");
            res.add("in");
            res.add("into");
            res.add("to");
            resu=w.solver(4,res,s);
            for(String i:resu){
                System.out.println(i);
            }

        }

}