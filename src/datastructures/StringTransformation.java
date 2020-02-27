package datastructures;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class StringTransformation {
    static boolean oneCharDifference(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int diff = 0;
        for (int i = 0; i < w1.length; i++) {
            if (w1[i] != w2[i]) {
                diff++;
            }
        }
        return diff == 1;
    }

    static String[] string_transformation(String[] words, String start, String stop) {
        Map<String, String> parent = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        if(words.length < 1000) {
            while (!queue.isEmpty()) {
                String t = queue.poll();

                if (oneCharDifference(t, stop)) {
                    parent.put(stop, t);
                    return getResult(start, stop, parent);
                }

                for (int i = 0; i < words.length; i++) {
                    if (!parent.containsKey(words[i]) && oneCharDifference(t, words[i])) {
                        parent.put(words[i], t);
                        queue.offer(words[i]);
                    }
                }
                if (!t.equalsIgnoreCase(start) && t.equalsIgnoreCase(stop)) {
                    return getResult(start, stop, parent);
                }
            }
        } else {
            Set<String> dict = new HashSet<>(Arrays.asList(words));
            while (!queue.isEmpty()) {
                String t = queue.poll();
                char[] chars = t.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char c = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (c != j) {
                            chars[i] = j;
                            String newWord = new String(chars);
                            if (newWord.equalsIgnoreCase(stop)) {
                                parent.put(newWord, t);
                                return getResult(start, stop, parent);
                            }
                            if (dict.contains(newWord)) {
                                if (!parent.containsKey(newWord)) {
                                    parent.put(newWord, t);
                                    queue.offer(newWord);
                                }
                            }
                            chars[i] = c;
                        }
                    }
                }
            }
        }
        return new String[]{"-1"};
    }

    private static String[] getResult(String start, String stop, Map<String, String> parent) {
        List<String> result = new ArrayList<>();
        String word = stop;
        while (!word.equalsIgnoreCase(start) || result.size() == 0) {
            result.add(0, word);
            word = parent.get(word);
        }
        result.add(0, start);
        return result.stream().toArray(String[]::new);
    }

    public static void main(String[] args) throws IOException {


        String[] words = {"HAC","BAC","HAD"};

        String start = "BAT";

        String stop = "HAD";

        String[] res = string_transformation(words, start, stop);

        for (int resItr = 0; resItr < res.length; resItr++) {
            System.out.println(res[resItr]);
        }
        String s="flow";
        String p="fow";
        System.out.println("index"+p.indexOf("zas"));


    }
}
