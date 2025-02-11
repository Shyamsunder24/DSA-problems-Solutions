Given an undirected graph, you have to find if there exists a path between 2 given nodes of the graph.

Input Format
The first line of input contains T - number of test cases. First line of each test case contains N - number of nodes and M - number of edges. It is followed by M lines, each contains a pair (u,v) - denoting an undirected edge between node u and node v. The next line contains Q - number of queries. Its followed by Q lines, each contains a pair (S,D) - denoting an query to check if there exits a path between node S and node D.

Output Format
For each test case, first print the test case number as shown. For each query of a test case, print "Yes" if path exists between the nodes of the query, print "No" otherwise, separated by new line.

Constraints
1 <= T <= 1000
1 <= N <= 100
0 <= M, Q <= min(N*N, 100)
1 <= u, v, S, D <= N

Example
Input
2
5 3
1 3
2 4
3 2
4
1 5
3 4
4 5
1 4
10 9
3 4
5 1
2 5
4 6
2 3
6 3
1 4
8 9
8 10
5
2 4
8 4
9 10
10 5
9 7

Output
Test Case #1:
No
Yes
No
Yes
Test Case #2:
Yes
No
Yes
No
No

import java.io.*;
import java.util.*;

public class Main {

    public static boolean path(ArrayList <Integer>[]graph,int s,int d,boolean vis[]){
        if(s==d) return true;
        vis[s]=true;
        for(int i : graph[s]){
            if(!vis[i] && path(graph,i,d,vis))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner (System.in);
        int t=s.nextInt();
        for(int te=1;te<=t;te++){
            System.out.println("Test Case #"+te+":");
            int n=s.nextInt();
            int m=s.nextInt();
            //adjacency list
            ArrayList<Integer>[]graph=new ArrayList[n+1];
            for(int i=0;i<=n;i++) graph[i]=new ArrayList<Integer>();
            //insert into graph 
            while(m-->0){
                int u=s.nextInt();
                int v=s.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
            //queries
            int q=s.nextInt();
            while(q-->0){
                boolean vis[]=new boolean[n+1];
                System.out.println((path(graph,s.nextInt(),s.nextInt(),vis))?"Yes":"No");
            }
        }
    }
}
