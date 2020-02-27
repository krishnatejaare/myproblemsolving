package datastructures;

import java.util.ArrayList;
import java.util.List;

public class Node{
    public String value;
    public List<Node> children=null;

    public Node(String value){
        this.value=value;
        this.children=new ArrayList<>();
    }
    public void addChild(Node node){
        children.add(node);
    }

    public static void main(String[]args){
        Node root=new Node("Suneetha");
        root.addChild(new Node("Krishna"));
        root.addChild(new Node("Ravi"));
        System.out.println(root.value);
        System.out.println(root.children.get(0).value);
    }



}




