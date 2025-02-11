Given the preorder and inorder traversals of a binary tree with unique elements, print the PostOrder Traversals of the tree.

Input Format
The first line of input contains T - the number of test cases. It's followed by 3T lines. The first line of each test case contains N - the number of nodes in the BST. The second line contains N unique integers denoting the preorder traversal of the tree. The third line contains N unique integers denoting the inorder traversal of the tree.

Output Format
For each test case, print the PostOrder Traversal of the Binary Tree, separated by a newline.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Example
Input
3
7
1 2 4 5 3 6 7
4 2 5 1 6 3 7
10
8 5 9 7 1 12 2 4 11 3
9 5 1 7 2 12 8 4 3 11
9
2 7 3 6 8 11 5 9 4
3 7 8 6 11 2 5 4 9

Output
4 5 2 6 7 3 1
9 1 2 12 7 5 3 11 4 8
3 8 11 6 7 4 9 5 2

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
    public void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    int p=0;
    int i=0;
    public Node consrtuct(int pre[],int in[],int low){
        if(p>=pre.length) return null;
        if(in[i]==low){
            ++i;
            return null;
        } 
        Node root=new Node(pre[p++]);
        root.left=consrtuct(pre,in,root.data);
        root.right=consrtuct(pre,in,low);
        return root;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int pre[]=new int[n];
            int in[]=new int[n];
            for(int i=0;i<n;i++) pre[i]=s.nextInt();
            for(int i=0;i<n;i++) in[i]=s.nextInt();
            binarysearchtree bst=new binarysearchtree();
            bst.root=bst.consrtuct(pre,in,Integer.MIN_VALUE);
            bst.postorder(bst.root);
            System.out.println();
        }
    }
}
