Given an undirected graph, you have to find the number of connected components in the graph.

Input Format
The first line of input contains T - number of test cases. First line of each test case contains N - number of nodes and M - number of edges. It is followed by M lines, each contains a pair (u,v) - denoting an undirected edge between node u and node v.

Output Format
For each test case, print the number of connected components, separated by new line.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= M <= min(N*N, 1000)
1 <= u, v <= N

Example
Input
2
5 3
1 3
2 4
3 2
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

Output
2
3

import java.io.*;
import java.util.*;

public class Main {

    // public static void bfs(ArrayList<Integer>[]graph,int s,int d,boolean vis[]){
    //     if(s==d) return;
    //     vis[s]=true;
    //     for(int i:graph[s]){
    //         if(!vis[i])
    //             dfs(graph,i,d,vis);
    //     }
    //     return;
    // }
    public static void bfs(ArrayList<Integer>[]graph,int s,int d,boolean vis[]){
        if(s==d) return;
        vis[s]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()){
            int x=q.remove();
            for(int i:graph[x]){
                if(!vis[i]){
                    q.add(i);
                    vis[i]=true;
                }
            }
        }
    }

    public static int solve(ArrayList<Integer>[]graph,int n,boolean vis[]){
        int count=0;
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                vis[i]=true;
                count++;
                bfs(graph,i,n,vis);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        for(int te=1;te<=t;te++){
            String in[]=br.readLine().split(" ");
            int n=Integer.parseInt(in[0]);
            int m=Integer.parseInt(in[1]);
            //adjacency list
            ArrayList<Integer>[]graph=new ArrayList[n+1];
            for(int i=0;i<=n;i++) graph[i]=new ArrayList<Integer>();
            //insert into graph 
            while(m-->0){
                String ins[]=br.readLine().split(" ");
                int u=Integer.parseInt(ins[0]);
                int v=Integer.parseInt(ins[1]);
                graph[u].add(v);
                graph[v].add(u);
            }
            boolean vis[]=new boolean[n+1];
            System.out.println(solve(graph,n,vis));
        }
    }
}
