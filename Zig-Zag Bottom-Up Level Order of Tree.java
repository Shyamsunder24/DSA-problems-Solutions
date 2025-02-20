Given an array of unique elements, construct a Binary Search Tree and print the Level Order of the tree in a zig-zag fashion, not top-down, but bottom-up. Assume the root is at level-1, zig-zag means that nodes at even levels will be printed left to right and the nodes at odd levels will be printed from right to left.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Output Format
For each test case, print the bottom-up Level Order Traversal of the Binary Search Tree in a zig-zag fashion, separated by a newline.

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
5 4 3 2 1
5 1 2 4 3
7 17 15 1 0 5 4
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
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(root==null) return;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> cur=new ArrayList<>();
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                ans.add(cur);
                cur=new ArrayList<Integer>();
                if(!q.isEmpty()) q.add(null);
            }
            else{
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                cur.add(curr.data);
            }
        }
        for(int i=ans.size()-1;i>=0;i--){
            ArrayList<Integer> x=ans.get(i);
            if(i%2!=0){
                for(int j=0;j<x.size();j++)   System.out.print(x.get(j)+" ");
            }
            else{
                for(int j=x.size()-1;j>=0;j--)   System.out.print(x.get(j)+" ");
            }
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
