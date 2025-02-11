Given an array of unique elements, construct a Binary Search Tree and print the right-view of the tree. The right view of a tree is the set of nodes visible when the tree is viewed from the right side.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - the value of the nodes.

Output Format
For each test case, print the right view of the Binary Search Tree, separated by a new line.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

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
3 4 5 
4 5 15 17 

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
    int max=0;
    public void rightview(Node root,int prev){
        if(root==null) return;
        int curr=prev+1;
        if(curr>max){
            System.out.print(root.data+" ");
            max=curr;
        }
        rightview(root.right,curr);
        rightview(root.left,curr);
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
            bst.rightview(bst.root,0);
            System.out.println();
        }
    }
}
