You are given Q queries. Each query can be one of four types:
1 X: Insert an integer X into the binary search tree.2 X: Delete X from the tree and replace it with the smallest value from its right sub-tree.3 X: Print "Yes" if the value exists in the binary search tree, print "No" otherwise.4: Print the Preorder traversal of the binary search tree.Input Format
The first line of input contains T - the number of test cases.
The second line contains Q - the number of queries. The Q subsequent lines each contain 2 integers A - the type of query and X - the value to be processed in the query (except for query of type 4).

Output Format
For each test case, print the result, separated by a newline. For any query, if no result exists, print "null".

Constraints
1 <= T <= 100
1 <= Q <= 100
1 <= A <= 4
-105 <= X <= 105

Example
Input
2
8
1 4
1 2
1 6
1 8
2 2
3 3
4
3 1
7
1 5
1 7
1 3
4
3 3
2 3
3 3

Output
Case #1:
No
4 6 8
No
Case #2:
5 3 7
Yes
No

import java.io.*;
import java.util.*;
//class


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

    public static Node delete(Node root,int b){
        if(root==null) return null;
        if(root.data<b) root.right=delete(root.right,b);
        else if(root.data>b) root.left=delete(root.left,b);
        else{
            if(root.left==null && root.right==null) return null;
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            root.data=findmin(root.right);
            root.right=delete(root.right,root.data);
        }
        return root;
    }

    public static boolean search(Node root,int b){
        if(root==null) return false;
        if(root.data==b) return true;
        if(root.data < b) return search(root.right,b);
        return search(root.left,b); 
    }
    public static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static int findmin(Node root){
        if(root==null) return Integer.MAX_VALUE;
        return Math.min(Math.min(findmin(root.left),findmin(root.right)),root.data);
    }
}
public class Main{
    //main method
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=1;i<=t;i++){
            System.out.println("Case #"+i+":");
            int q=s.nextInt();
            binarysearchtree bst=new binarysearchtree();
            while(q-->0){
                int a=s.nextInt();
                int b=0;
                if(a!=4) {
                    b=s.nextInt();
                }
                //insert
                if(a==1) {
                    bst.root=bst.insert(bst.root,b);
                }
                //delete
                else if(a==2) bst.root=bst.delete(bst.root,b);
                //search
                else if(a==3) {
                    if(bst.search(bst.root,b)) System.out.println("Yes");
                    else System.out.println("No");
                }
                //preorder
                else {
                    bst.preorder(bst.root);
                    System.out.println();
                }
            }
        }
    }
}
