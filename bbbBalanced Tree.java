Given an array of unique elements, construct a Binary Search Tree and check if it is balanced. A tree is said to be balanced if, for every node, the difference between the height of its child nodes is not greater than 1.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Output Format
For each test case, print "Yes" if the Binary Search Tree is balanced, "No" otherwise, separated by a newline.

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
No
Yes
No

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
    public boolean isbalaced(Node root){
        if(root==null) return true;
        if(height(root)==-1) return false;
        return true;
    }
    public int height(Node root){
        if(root==null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        if(lh==-1 || rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;
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
            if(bst.isbalaced(bst.root)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
