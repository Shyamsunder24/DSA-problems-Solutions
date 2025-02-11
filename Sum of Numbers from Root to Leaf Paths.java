Given an array of unique elements, construct a Binary Search Tree and print the sum of all the numbers formed along the path from the root node to the leaf nodes.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Output Format
For each test case, print the sum separated by a newline. Since the output can be very large, print output % 1000000007.

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
4 5 15 2 1 7 17

Output
12345
666
497095

Explanation

Example 1: 
Total Sum = 12345

Example 2: 
Total Sum = 321 + 345 = 666

Example 3: 
Total Sum = 421 + 45157 + 451517 = 497095

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
    int mod=(int)(1e9+7);
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

    public long solve(Node root,long v){
        if(root==null) return 0;
        v=(v*(int)Math.pow(10,nodigit(root.data))+root.data)%mod;
        if(root.left==null && root.right==null) return v; 
        return (solve(root.left,v)+solve(root.right,v))%mod;
    }

    public int nodigit(int n){
        if(n==0) return 1;
        int count=0;
        while(n!=0){
            n=n/10;
            ++count;
        }
        return count;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int mod=(int)(1e9+7);
            int n=s.nextInt();
            binarysearchtree bst=new binarysearchtree();
            for(int i=0;i<n;i++) bst.root=bst.insert(bst.root,s.nextInt());
            System.out.println(bst.solve(bst.root,0)%mod);
        }
    }
}
