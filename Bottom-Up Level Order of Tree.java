Given an array of unique elements, construct a Binary Search Tree and print the Level Order of the tree, not top-down, but bottom-up.

Input Format
 The first line of input contains T - number of test cases. Its followed by 2T lines. First line of each test case contains N - number of nodes in the BST. The next line contains N unique integers - value of the nodes. 

Output Format
 For each test case, print the bottom-up Level Order of the Binary Search Tree, separate each level by newline. Separate the output of different test cases with an extra newline.

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
 5 
 4 
 3 
 2 
 1 

 1 5 
 2 4 
 3 

 7 17 
 1 15 
 0 5 
 4

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

    public void levelorder(Node root){
        if(root==null) return;
        Queue<Node> q=new ArrayDeque<>();
        Stack<Node> st=new Stack<>();
        Stack<Integer> sizes=new Stack<>();
        q.offer(root);//add into queue
        while(!q.isEmpty()){
            int size=q.size();
            sizes.push(size);
            for(int i=0;i<size;i++){
                Node curr=q.poll();//remove front of queue
                st.push(curr);
                if(curr.right!=null) q.offer(curr.right);
                if(curr.left!=null) q.offer(curr.left);
            }
        }
        while(!st.isEmpty()){
            int curr=sizes.pop();
            for(int i=0;i<curr;i++) 
                System.out.print(st.pop().data+" ");
            System.out.println();
        }
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
            bst.levelorder(bst.root);
            System.out.println();
        }
    }
}
