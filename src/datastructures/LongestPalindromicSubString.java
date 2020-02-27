package datastructures;

public class LongestPalindromicSubString {
    int start_index=0;
    int current_length=0;
    public String palindrome(String s){
        if (s == null || s.length() < 1) return "";
        int startIndex = 0;
        int maxLength =0;
        int n=s.length();
        boolean [][] pal =new boolean[n][n];
        for(int i=0;i<n;i++){
            pal[i][i]=true;
            maxLength =1;
            startIndex =i;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                pal[i][i+1] = true;
                maxLength =2;
                startIndex =i;
            }
        }

        for(int currentLength =3;currentLength<=n;currentLength++){
            for(int i=0;i<n-currentLength+1;i++){
                int j=currentLength+i-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(pal[i+1][j-1]==true){
                        pal[i][j]=true;
                        maxLength =currentLength;
                        startIndex =i;
                    }
                }
            }
        }
        return s.substring(startIndex, startIndex+maxLength);
    }
    public static void main (String args[])
    {
        LongestPalindromicSubString l=new LongestPalindromicSubString();
        //String s="banana";
        String s="abcba";

        System.out.println(l.palindrome(s));

    }
}
