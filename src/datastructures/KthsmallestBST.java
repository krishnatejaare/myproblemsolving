package datastructures;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class KthsmallestBST {

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

    static TreeNode bst_insert(TreeNode root, int val)
    {
        if (root == null)												// destination.
        {
            return new TreeNode(val);
        }
        if (val <= root.val)											// element is <= hence insert it in left subtree.
        {
            root.left_ptr = bst_insert(root.left_ptr, val);			      // if root->left_ptr is null then new TreeNode will be created and root->left_ptr is assigned its address else it will be assigned to the same value as previouly stored.
        }
        else  															// element is > hence insert it in right subtree.
        {
            root.right_ptr = bst_insert(root.right_ptr, val);			// if root->right_ptr is null then new TreeNode will be created and root->right_ptr is assigned its address else it will be assigned to the same value as previouly stored.
        }
        return root;
    }
    static int kth_smallest_element(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count=0;
        int result=0;
        if(root==null) return 0;

        while(true){
            if(root!=null){
                stack.push(root);
                root=root.left_ptr;
            }
            else{
                if(stack.isEmpty()) break;
                TreeNode temp=stack.pop();
                int pump=temp.val;
                count=count+1;
                if(count==k){
                    result=pump;
                    break;
                }

                root=temp.right_ptr;

            }

        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.nextLine().trim());

        TreeNode root = null;

        for (int i = 0; i < N; i++)
        {
            int data = Integer.parseInt(in.nextLine().trim());
            root = bst_insert(root, data);
        }

        int k= Integer.parseInt(in.nextLine().trim());

        int ans = kth_smallest_element(root, k);

        bw.write(String.valueOf(ans));
        bw.newLine();

        bw.close();
    }
}
