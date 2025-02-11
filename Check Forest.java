Given an undirected graph, determine if the given graph is a forest. A forest is a disjoint union of trees. A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any acyclic-connected graph is a tree.

Input Format
The first line of input contains T - the number of test cases. The first line of each test case contains N - number of nodes and M - number of edges. It is followed by M lines, each containing a pair (u,v) - denoting an undirected edge between node u and node v.

Output Format
For each test case, print "Yes" if the graph is a forest, print "No" otherwise, separated by a newline.

Constraints
1 <= T <= 1000
1 <= N <= 10000
1 <= M <= N
1 <= u, v <= N

Example
Input
4
5 4
1 3
2 3
4 5
2 1
5 3
1 3
2 3
4 5
5 4
1 2
3 4
1 3
4 5
6 5
1 4
2 4
3 5
5 6
2 1

Output
No
Yes
Yes
No

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while(t-->0) {
            int n = s.nextInt();
            int m = s.nextInt();
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int u = s.nextInt();
                int v = s.nextInt();
                graph.get(u).add(v);
                graph.get(v).add(u);
            }
            if (isForest(graph, n)) System.out.println("Yes"); 
            else System.out.println("No");
        }
    }
    
    public static boolean isForest(List<List<Integer>> graph, int N) {
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (isCyclic(graph, i, visited, -1)) return false;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
    
    public static boolean isCyclic(List<List<Integer>> graph, int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                if (isCyclic(graph, neighbor, visited, v)) return true;
            } 
            else if (neighbor != parent) return true;
        }
        return false;
    }
}
