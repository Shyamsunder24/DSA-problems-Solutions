Given an array of unique elements, construct a Binary Search Tree and check if it is a Complete Binary Tree [CBT]. In a Complete Binary Tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines. The first line of each test case contains N - the number of nodes in the BST. The next line contains N unique integers - value of the nodes.

Output Format
For each test case, print "Yes" if it is a Complete Binary Search Tree, "No" otherwise, separated by a newline.

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
4 2 5 3 1
7
4 5 15 0 1 7 17

Output
No
Yes
No

Explanation

Self Explanatory

import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            right=left=null;
        }
        public static Node insert(Node root,int ele){
            if(root==null) return new Node(ele);
            if(ele<root.data)   root.left=insert(root.left,ele);
            else    root.right=insert(root.right,ele);
            return root;
        }
        
        public static boolean check(Node root){
            if(root==null) return true;
            Queue<Node> q=new LinkedList<>();
            q.add(root);
            boolean ne=false;
            while(!q.isEmpty()){
                Node curr=q.poll();
                if(curr==null) ne=true;
                else{
                    if(ne) return false;
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            
            return true;
        }

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc=new Scanner (System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Node root = new Node(sc.nextInt());
            for(int i=1;i<n;i++){
                root=root.insert(root,sc.nextInt());
            }
            
            System.out.println(root.check(root)?"Yes":"No");
        }
    }
}
