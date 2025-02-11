You are given two integers L, R, and an array of unique elements, construct a Binary Search Tree from the array, and then trim the BST in a manner such that all its elements lie between [L, R].
Trimming the tree should not change the relative structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant).

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains three integers, N - the number of nodes in the BST, L - the lower limit of the range, and R - the upper limit of the range. The next line contains N unique integers - value of the nodes.

Output Format
For each test case, print the preorder traversal of the trimmed tree, separated by a newline.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Example
Input
3
5 2 4
1 2 3 4 5
5 1 4
3 2 4 1 5
7 2 10
4 5 15 0 1 7 17

Output
2 3 4
3 2 1 4
4 5 7

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
    int a,b;
    public binarysearchtree(int a,int b){
        this.root=null;
        this.a=a;
        this.b=b;
    }
    
    public Node insert(Node root,int b){
        if(root==null) 
            return new Node(b);
        if(root.data<b) 
            root.right=insert(root.right,b);
        else if(root.data>b) 
            root.left=insert(root.left,b);
        return root;
    }

    public Node trim(Node root){
        if(root==null) 
            return null;
        
        if(root.data<a) {
            // System.out.print(root.data+" ");
            return trim(root.right);
        }
        if(root.data>b) 
            return trim(root.left);
        root.left=trim(root.left);
        root.right=trim(root.right);
        return root;
    }
    public void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a=s.nextInt();
            int b=s.nextInt();
            binarysearchtree bst=new binarysearchtree(a,b);
            for(int i=0;i<n;i++) {
                bst.root=bst.insert(bst.root,s.nextInt());
            }
            bst.root = bst.trim(bst.root);
            bst.preorder(bst.root);
            System.out.println();
        }
    }
}
