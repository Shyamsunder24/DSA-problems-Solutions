Given an array of unique elements, construct a Binary Search Tree and find the diameter of the tree. Diameter is defined as the number of nodes on the longest path between 2 nodes of the tree.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - the value of the nodes.

Output Format
For each test case, print the diameter of the Binary Search Tree, separated by a newline.

Constraints
1 <= T <= 1000
1 <= N <= 5000
0 <= ar[i] <= 10000

Example
Input
3
5
1 2 3 4 5 
5
2 4 3 1 5 
7
4 5 15 0 1 7 17

Output
5
4
6

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
class Main{
    static int ans=0;
    public static Node insert(Node root,int b){
        if(root==null) 
            return new Node(b);
        if(root.data<b) 
            root.right=insert(root.right,b);
        else if(root.data>b) 
            root.left=insert(root.left,b);
        return root;
    }
    public static int height(Node root){
        if(root==null) return 0;
        int l=height(root.left);
        int r=height(root.right);
        ans=Math.max(ans,l+r+1);
        return Math.max(l,r)+1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        // Scanner s=new Scanner(System.in);
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            Node root=null;
            String in[]=br.readLine().split(" ");
            for(int i=0;i<n;i++) root=insert(root,Integer.parseInt(in[i]));
            ans=0;
            int m=height(root);
            System.out.println(ans);
        }
    }
}
