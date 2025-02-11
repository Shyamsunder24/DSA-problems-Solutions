Given an array of unique elements, construct a Binary Search Tree and for every node, print the depth of that node.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Output Format
For each test case, print the depth of every node of the Binary Search Tree, separated by a newline.

Constraints
1 <= T <= 1000
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
0 1 2 3 4
0 1 1 2 2
0 1 2 1 2 3 3

import java.io.*;
import java.util.*;
class Node{
    int data,depth;
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
        if(root==null)
            return new Node(b);
        if(root.data<b) 
            root.right=insert(root.right,b);
        else if(root.data>b) 
            root.left=insert(root.left,b);
        return root;
    }
    // void fill(Node root,int d){
    //     if(root==null) return;
    //     root.depth=d;
    //     fill(root.left,d+1);
    //     fill(root.right,d+1);
    // }
    
    // public void preorder(Node root){
    //     if(root==null) return;
    //     System.out.print(root.depth+" ");
    //     preorder(root.left);
    //     preorder(root.right);
    // }
    public int find(Node root,int val,int d){
        if(root==null) return -1;
        if(root.data==val) return d;
        else if(root.data>val) return find(root.left,val,d+=1);
        else return find(root.right,val,d+=1); 
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
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            for(int i=0;i<n;i++){
                bst.root=bst.insert(bst.root,a[i]);
            }
            // bst.fill(bst.root);
            // bst.preorder(bst.root);
            for(int i=0;i<n;i++){
                System.out.print(bst.find(bst.root,a[i],0)+" ");
            }
            System.out.println();
        }
    }
}
