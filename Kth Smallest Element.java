You are given an integer K and an array of distinct integers of size N. Find the Kth smallest element from the array.

Note: 
 Try solving with the help of MaxHeap or QuickSelect, don't solve using sorting.  Input Format
The first line of input contains T - the number of test cases. For each test case, the first line contains N - the size of the array. The second line contains N integers - the elements of the array.

Output Format
For each test case, print the Kth smallest element from the array, separated by a newline.

Constraints
1 <= T <= 100
1 <= K <= N <= 105
0 <= A[i] <= 105

Example
Input
2
5 3
1 5 13 2 8
6 2
10 1 20 8 31 12

Output
5
8

import java.io.*;
import java.util.*;

public class Main {

    public static int Ksmallestele(int a[],int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<a.length;i++) pq.add(a[i]);
        int ans=0;
        while(k-->0){
            ans=pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String in[]=br.readLine().split(" ");
            int n=Integer.parseInt(in[0]);
            int k=Integer.parseInt(in[1]);
            int a[]=new int[n];
            String ar[]=br.readLine().split(" ");
            for(int i=0;i<n;i++) a[i]=Integer.parseInt(ar[i]);
            System.out.println(Ksmallestele(a,k));
        }
    }
}
