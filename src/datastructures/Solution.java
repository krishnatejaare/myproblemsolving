package datastructures;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED


    public class doublecomparator implements Comparable<doublecomparator>{
        private double score;
        public doublecomparator(double score){
            this.score = score;
        }
        @Override
        public int compareTo(doublecomparator o) {
            return new Double(score).compareTo( o.score);
        }
        @Override
        public String toString() {
            return String.valueOf(score);
        }
    }
    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {
        // WRITE YOUR CODE HERE

        List<doublecomparator> out = new ArrayList<doublecomparator>();

        HashMap<Double,Integer>hashmap=new HashMap<>();
        double [] result_distance=new double[numDestinations];
        for(int i=0;i<numDestinations;i++){
            List<Integer>point=allLocations.get(i);
            int x_distance=point.get(0);
            int y_distance=point.get(1);
            int sqare_distance=x_distance^2+y_distance^2;
            double distance=Math.sqrt(sqare_distance);
            System.out.println(distance);
            //result_distance[i]=distance;
            out.add(new doublecomparator(distance));
            hashmap.put(distance,i);
        }

        Collections.sort(out);
        List<List<Integer>>result=new ArrayList<List<Integer>>();
        for(int k=0;k<numDeliveries;k++){
            result.add(allLocations.get(hashmap.get(out.get(k))));
        }


        return result;
    }
    public static void main(String args[])
    {
        Solution s=new Solution();
        List<List<Integer>> allLocations=new ArrayList<List<Integer>>();
        List<Integer>point=new ArrayList<Integer>();
        point.add(1);
        point.add(2);
        allLocations.add(point);
        List<Integer>mpoint=new ArrayList<Integer>();
        point.add(3);
        point.add(4);
        allLocations.add(mpoint);
        List<Integer>npoint=new ArrayList<Integer>();
        point.add(1);
        point.add(-1);
        allLocations.add(npoint);

        s.ClosestXdestinations(3,allLocations,2);
    }
    // METHOD SIGNATURE ENDS
}