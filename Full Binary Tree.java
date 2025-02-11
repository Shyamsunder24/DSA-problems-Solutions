Given an array of unique elements, construct a Binary Search Tree and check if it is a Full Binary Tree [FBT]. A FBT is one in which each node is either a leaf or possesses exactly 2 child nodes.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Output Format
For each test case, print "True" if the Binary Search Tree is an FBT, "False" otherwise, separated by a newline.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Example
Input
3
5
1 2 3 4 5
11
8 3 30 15 40 18 12 17 25 1 7
7
4 5 15 0 1 7 17

Output
False
True
False

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
class binarysearchtree{
    Node root;
    public binarysearchtree(){
        this.root=null;
    }
    
    public Node insert(Node root,int b){
        if(root==null) return new Node(b);
        if(root.data<b) root.right=insert(root.right,b);
        else if(root.data>b) root.left=insert(root.left,b);
        return root;
    }

    public boolean checkfbt(Node root){
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(root.left!=null && root.right!=null)
            return checkfbt(root.left) && checkfbt(root.right);
        return false;
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            binarysearchtree bst=new binarysearchtree();
            for(int i=0;i<n;i++) bst.root=bst.insert(bst.root,s.nextInt());
            if(bst.checkfbt(bst.root)) System.out.println("True");
            else System.out.println("False");
        }
    }
}
