Given an array of unique elements, construct a Binary Search Tree and print the top-view of the tree. The top view of a tree is the set of nodes visible when the tree is viewed from the top.

Input Format
Given an array of unique elements, construct a Binary Search Tree and print the top-view of the tree. The top view of a Tree is the set of nodes visible when the tree is viewed from the top.

The first line of input contains T - the number of test cases. It is followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - the value of the nodes.

Output Format
For each test case, print the top view of the Binary Search Tree, separated by a new line. Print the set of visible nodes from left to right.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Example
Input 
3
6
10 20 13 3 17 18 
6
10 3 20 15 14 12 
7
10 3 8 20 7 6 4 

Output
3 10 20 18 
12 3 10 20 
4 6 3 10 20 


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
class Pair{
    Node root;
    int level;
    Pair(Node root,int level){
        this.root=root;
        this.level=level;
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

    public void print(Node root){
        TreeMap<Integer,Integer> hm=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            Node present=curr.root;
            int pl=curr.level;
            if(!hm.containsKey(pl)) hm.put(pl,present.data);
            if(present.left!=null)
               q.offer(new Pair(present.left,pl-1));
            if(present.right!=null)
                q.offer(new Pair(present.right,pl+1));
        }
        for(int i :hm.values())
            System.out.print(i+" ");
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader is=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(is);
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String a[]=br.readLine().split(" ");
            binarysearchtree bst=new binarysearchtree();
            for(int i=0;i<n;i++){
                bst.root=bst.insert(bst.root,Integer.parseInt(a[i]));
            }
            bst.print(bst.root);
            System.out.println();
        }
    }
}
