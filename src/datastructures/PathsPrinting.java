package datastructures;


import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

class PathsPrinting  {
    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int value) {
            this.val = value;
        }
    }

    static Node createTree(String data) {
        if (data == null || data.length() == 0) return null;
        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }

    static Node deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens())
            return null;
        String s = st.nextToken();
        if (s.equals("#"))
            return null;
        Node root = new Node(Integer.valueOf(s));
        root.left = deserialize(st);
        root.right = deserialize(st);

        return root;
    }

    static void printInorder(Node root) {
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }

    static void printAllPaths(Node root) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        paths(root,array);
    }

    static void paths(Node root,ArrayList<Integer>array){
        if(root==null)return;
        array.add(root.val);
        if(root.left==null && root.right==null){
            for(int i=0;i<array.size();i++)
            {
                System.out.print(array.get(i)+" ");
            }
            System.out.println();
            if(array.size()!=0)
            {
                array.remove(array.size()-1);
            }
        }

        paths(root.left,array);
        paths(root.right,array);
        if(array.size()!=0){
            array.remove(array.size()-1);}
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int _size;
        _size = Integer.parseInt(in.nextLine().trim());

        String _str;
        try {
            _str = in.nextLine();
        } catch (Exception e) {
            _str = null;
        }
        Node n = createTree(_str);
        printAllPaths(n);

    }
}



