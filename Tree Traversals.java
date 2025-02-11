Given an array of unique elements, construct a Binary Search Tree and print the Preorder, Inorder and Postorder Traversals of the tree.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Output Format
For each test case, print the PreOrder, InOrder and PostOrder Traversals of the Binary Search Tree, separate each traversal by a newline. Separate the output of different test cases with an extra newline.

Constraints
1 <= T <= 100
1 <= N <= 1000
0 <= ar[i] <= 10000

Example
Input
3
5
1 2 3 4 5
5
3 2 4 1 5
7
4 5 15 0 1 7 17

Output
1 2 3 4 5
1 2 3 4 5
5 4 3 2 1

3 2 1 4 5
1 2 3 4 5
1 2 5 4 3

4 0 1 5 15 7 17
0 1 4 5 7 15 17
1 0 7 17 15 5 4

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

    public void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            binarysearchtree bst=new binarysearchtree();
            for(int i=0;i<n;i++){
                bst.root=bst.insert(bst.root,s.nextInt());
            }
            bst.preorder(bst.root);
            System.out.println();
            bst.inorder(bst.root);
            System.out.println();
            bst.postorder(bst.root);
            System.out.println();
            System.out.println();
        }
    }
}
