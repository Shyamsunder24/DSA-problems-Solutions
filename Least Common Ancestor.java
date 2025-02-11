Given an array of unique elements, construct a Binary Search Tree. Now, given two nodes u and v of the BST, find their Lowest Common Ancestor (LCA). LCA is defined as the furthest node from the root that is an ancestor for both u and v.

Input Format
The first line of input contains T - the number of test cases. The first line of each test case contains N, Q - the number of nodes in the BST and the number of queries. The next line contains N unique integers - value of the nodes. It is followed by Q lines, each containing 2 nodes of the tree, u and v.

Output Format
For each test case, for each query print the LCA of the given nodes u and v, separated by space. Separate the output of different test cases with a newline.

Constraints
1 <= T <= 1000
1 <= N,Q <= 1000
0 <= ar[i] <= 10000

Example
Input
2
5 2
3 2 4 1 5
2 5
1 2
7 3
4 5 15 0 1 7 17
0 15
7 17
17 4

Output
3 2
4 15 4

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
    public Node lca(Node root,int a,int b){
        if(root==null) return null;
        if(root.data<a && root.data<b) return lca(root.right,a,b);
        else if(root.data>a && root.data>b) return lca(root.left,a,b);
        else return root;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int q=s.nextInt();
            binarysearchtree bst=new binarysearchtree();
            for(int i=0;i<n;i++) bst.root=bst.insert(bst.root,s.nextInt());
            for(int i=0;i<q;i++){
                int a=s.nextInt();
                int b=s.nextInt();
                Node c=bst.lca(bst.root,a,b);
                System.out.print(c.data+" ");
            }
            System.out.println();
        }
    }
}
