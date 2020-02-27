//package datastructures;
//
//public class largetbstinatree {
//
//    class MinMax{
//        int min;
//        int max;
//        int size;
//        boolean isBST;
//
//        MinMax(){
//            min = Integer.MAX_VALUE;
//            max = Integer.MIN_VALUE;
//            isBST = true;
//            size = 0;
//        }
//    }
//
//    private MinMax largest(Node root){
//        if(root==null) return new MinMax();
//
//        MinMax leftminmax=largest(root.left);
//        MinMax rightminmax=largest(root.right);
//
//        MinMax m = new MinMax();
//
//        if(leftminmax.isBST==false || rightminmax.isBST==false|| leftminmax.max<root.data || rightminmax.min>root.data)
//        {
//            m.isBST=false;
//            m.size=Math.max(leftminmax.size,rightminmax.size);
//            return m;
//        }
//
//        m.isBST = true;
//        m.size = leftminmax.size + rightminmax.size + 1;
//        m.min=root.left!=null ? leftminmax.min:root.data;
//        m.max=root.right!=null ? rightminmax.max:root.data;
//
//        return m;
//
//    }
//}
