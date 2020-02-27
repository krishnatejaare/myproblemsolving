package datastructures;

public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] strs={"flower","lig","flight"};
        String pre=strs[0];
        int i=1;
        while(i<strs.length){
            while(strs[i].indexOf(pre)!=0){
                pre=pre.substring(0,pre.length()-1);

            }
            i++;
        }
        System.out.println(pre);
    }
}
