package datastructures;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class createtree {

    static class TreeNode
    {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int _val)
        {
            val = _val;
            left_ptr = null;
            right_ptr = null;
        }
    };
    static TreeNode build_balanced_bst(int[] a)
    {


        return myfunction(a,0,a.length-1);

    }
    static TreeNode myfunction(int[]a,int left,int right){
        if(left>right) return null;
        int mid=middleelement(a,left,right);
            TreeNode root=new TreeNode(a[mid]);
            root.left_ptr=myfunction(a,left,mid-1);
            root.right_ptr=myfunction(a,mid+1,right);
        return root;
    }

    static int middleelement(int[]a,int left,int right){
        int mid=(left+right)/2;
        return mid;
    }
    static boolean check_balanced_bst(TreeNode root, int l, int r, int[] a)
    {
        if (l > r && root == null)                              // If no value in [l, r] and tree is also empty.
        {
            return true;
        }
        else if (l > r && root != null)                         // If no value in [l, r] but tree contains something.
        {
            return false;
        }
        if (root == null)                                       // If some values in [l, r] but tree is empty.
        {
            return false;
        }

        int mid1 = l + (r - l) / 2;
        int mid2 = l + (r - l + 1) / 2;

        boolean valid1 = (root.val == a[mid1] && check_balanced_bst(root.left_ptr, l, mid1 - 1, a) && check_balanced_bst(root.right_ptr, mid1 + 1, r, a));
        if (valid1)                                             // actually we are doing valid1 || valid2 but when valid1 is true then no need to find valid2
        {
            return true;
        }
        if (mid1 == mid2)                                       // when odd no of elements in [l, r] then mid1 = mid2 so valid1 = valid2 and no need to find valid2.
        {
            return false;
        }
        return (root.val == a[mid2] && check_balanced_bst(root.left_ptr, l, mid2 - 1, a) && check_balanced_bst(root.right_ptr, mid2 + 1, r, a));
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a_size = 0;
        a_size = Integer.parseInt(in.nextLine().trim());

        int[] a = new int[a_size];
        for(int i = 0; i < a_size; i++) {
            int a_item;
            a_item = Integer.parseInt(in.nextLine().trim());
            a[i] = a_item;
        }

        TreeNode root = build_balanced_bst(a);

        if (check_balanced_bst(root, 0, a_size - 1, a))
        {
            bw.write("Valid Balanced BST");
        }
        else
        {
            bw.write("Invalid Balanced BST");
        }
        bw.newLine();

        bw.close();
    }
}



