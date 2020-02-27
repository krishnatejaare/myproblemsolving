package datastructures;

public class targetsumrecuresion {

    public void targetSum(int[]a,int k,int pos,boolean[]incl){
        if(pos==a.length){
            int sum=0;
            for(int i=0;i<a.length;i++){
                if(incl[i]){
                    sum+=a[i];
                }
            }
            if(sum!=k) return;
            for(int i=0;i<a.length;i++){
                if(incl[i]){
                    System.out.print(a[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        targetSum(a,k,pos+1,incl);
        incl[pos]=true;
        targetSum(a,k,pos+1,incl);
        incl[pos]=false;
    }
    public static void main(String args[]) {
        targetsumrecuresion t=new targetsumrecuresion();
        int[]array={3,1,4};
        int target=4;
        boolean[]incl=new boolean[array.length];
        int pos=0;
        t.targetSum(array,target,pos,incl);
    }
}

//input
//3,1,4; targetsum=4
//output
//3,1; 4
//
//        targetSum(a,k,pos+1,incl);
//        incl[pos]=true;
//        targetSum(a,k,pos+1,incl);
//        incl[pos]=false;
//
//        3 false
//             1 false
//                 4 false
//                 4 true
//                      @4-----------------
//                 4 false
//             1 true
//                 4 false
//                      @1----------------
//                 4 true
//                      @1,@4-------------
//                 4 false
//             1 false
//
//        3 true
//              1 false
//                  4 false
//                      @3-------------------
//                  4 true
//                      @3,@4----------------
//                  4 false
//              1 true
//                  4 false
//                      @3,@1---------------
//                  4 true
//                      @3,@1,@4-------------
//                  4 false
//              1 false
//
//        3 false
