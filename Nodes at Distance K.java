Given an array of unique elements, construct a Binary Search Tree and find the number of nodes at a distance K from the given source node S. Distance is defined as the number of edges between 2 nodes.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N, S, K - the number of nodes in the BST, the source node, and the distance K. The next line contains N unique integers - the value of the nodes.

Output Format
For each test case, print the number of nodes in the Binary Search Tree which are K distance away from S, separated by newline.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Example
Input
3
5 3 2
1 2 3 4 5 
5 4 1
2 4 3 1 5 
7 5 2
4 5 15 0 1 7 17 

Output
2
3
3

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
    Node target;
    ArrayList<Integer> ans=new ArrayList<>();
    HashMap<Node,Node> parent=new HashMap<>();
    Node root;
    public binarysearchtree(){
        this.root=null;
    }
    
    public Node insert(Node root,int b){
        if(root==null) 
            return new Node(b);
        if(root.data<b) 
            root.right=insert(root.right,b);
        else if(root.data>b) 
            root.left=insert(root.left,b);
        return root;
    }
    // public boolean findpath(Node root,Node x,List<Node> l){
    //     if(root==null) return false;
    //     if(root==x || findpath(root.left,x,l) || findpath(root.right,x,l)){
    //         l.add(root);
    //         return true;
    //     }
    //     return false;
    // }
    // public int cnt(Node root,int k){
    //     if(root==null) return 0;
    //     if(k==0) return 1;
    //     return cnt(root.left,k-1)+cnt(root.right,k-1);
    // }
    // public int solve(Node root,Node so,int k){
    //     List<Node> l=new ArrayList<>();
    //     boolean b=findpath(root,so,l);
    //     int ans=cnt(so,k);
    //     k--;
    //     int i=l.size()-2;
    //     while(k>=0 && i>=0){
    //         if(l.get(i).right==l.get(i+1)) ans+=cnt(l.get(i).left,k-1);
    //         else ans+=cnt(l.get(i).right,k-1);
    //         k--;
    //         i--;
    //     }
    //     return ans;
    // }
    public ArrayList<Integer> distanceK(Node a,int b,int c){
        if(a==null) return ans;
        find(a,b);
        mark(a);
        Queue<Node> qu=new ArrayDeque<>();
        Set<Node> vis=new HashSet<>();
        qu.add(target);
        vis.add(target);
        int curr=0;
        while(!qu.isEmpty()){
            if(curr==c) break;
            curr++;
            int size=qu.size();
            for(int i=0;i<size;i++){
                Node cur=qu.poll();
                if(cur.left!=null && !vis.contains(cur.left)){
                    qu.add(cur.left);
                    vis.add(cur.left);
                }
                if(cur.right!=null && !vis.contains(cur.right)){
                    qu.add(cur.right);
                    vis.add(cur.right);
                }
                if(parent.get(cur)!=null && !vis.contains(parent.get(cur))){
                    qu.add(parent.get(cur));
                    vis.add(parent.get(cur));
                }
            }
        }
        while(!qu.isEmpty()){
            Node cur=qu.poll();
            ans.add(cur.data);
        }
        return ans;
    }
    public void find(Node root,int target_v){
        if(root==null) return;
        if(root.data==target_v){
            target=root;
            return;
        }
        find(root.left,target_v);
        find(root.right,target_v);
    }
    public void mark(Node root){
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        parent.put(root,null);
        while(!queue.isEmpty()){
            Node curr=queue.poll();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                queue.add(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                queue.add(curr.right);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String []str=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            Node s=new Node(Integer.parseInt(str[1]));
            int k=Integer.parseInt(str[2]);
            binarysearchtree bst=new binarysearchtree();
            String []in=br.readLine().split(" ");
            for(int i=0;i<n;i++){
                bst.root=bst.insert(bst.root,Integer.parseInt(in[i]));
            }
            System.out.println((bst.distanceK(bst.root,s.data,k)).size());
        }
    }
}
