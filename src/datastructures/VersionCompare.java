package datastructures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class VersionCompare {

    public static int compare(String a, String b) {
        List<Integer> aList = toListOfInts(a);
        List<Integer> bList = toListOfInts(b);

        for(int i = 0; i < aList.size() || i < bList.size(); i++) {
            int a0 = getAtOffset(aList, i, -1);
            int b0 = getAtOffset(bList, i, -1);
            if (a0 != b0) {
                return a0 - b0;
            }
        }
        return 0;
    }

    private static List<Integer> toListOfInts(String s) {
        return Arrays.stream(s.split("\\."))
                .map(Integer::valueOf)
                .collect(toList());
    }

    private static int getAtOffset(List<Integer> ints, int index, int defaultValue) {
        if (index + 1 > ints.size()) {
            return defaultValue;
        }
        return ints.get(index);
    }

    public static void main(String[] args) {
//        if (args.length != 2) {
//            System.err.println("Usage: VersionCompare VERSION1 VERSION2");
//            System.exit(-1);
//        }

//        String a = args[0];
//        String b = args[1];
        String a = "10.14";
        String b = "10.14.0";
        int result = compare(a, b);
        if (result < 0) {
            System.out.println(format("'%s' is lower than '%s'", a, b));
        } else if(result > 0) {
            System.out.println(format("'%s' is higher than '%s'", a, b));
        } else {
            System.out.println(format("The versions '%s' and '%s' are the same", a, b));
        }
    }
}