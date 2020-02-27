package datastructures;

public class CoinDenomination {
    public int ways(int[]array,int sum){

        int row=array.length+1;
        int col=sum+1;

        int[][] matrix=new int[row][col];

        for(int i=0;i<col;i++){
            matrix[0][i]=0;
        }

        for(int i=0;i<row;i++){
         matrix[i][0]=1;
        }

        for(int k=1;k<row;k++){
            for(int i=1;i<col;i++){
                if(i<k){
                    matrix[k][i]=matrix[k-1][i];
                }
                else{
                    matrix[k][i]=matrix[k-1][i]+matrix[k][i-k];
                }

            }
        }

        return matrix[array.length][sum];

    }
    public static void main (String args[])
    {
        CoinDenomination cd=new CoinDenomination();
        int[]array={1,2,3};
        int sum=6;
        int result=cd.ways(array,sum);
        System.out.println(result);

    }
}
