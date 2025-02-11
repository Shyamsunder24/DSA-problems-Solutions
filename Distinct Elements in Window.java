Given an array of integers and a window size K, find the number of distinct elements in every window of size K of the given array.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains the N-size of the array and the K-size of the window. The second line contains N integers - elements of the array.

Output Format
For each test case, print the number of distinct elements in every window of size K, separated by a new line.

Constraints
30 points
1 <= N <= 100
1 <= K <= N

70 points
1 <= N <= 10000
1 <= K <= N

General Constraints
1 <= T <= 1000
-100 <= ar[i] <= 100

Example
Input
3
5 3
-2 -4 -2 4 -2
10 7
3 -4 -3 -4 -2 0 2 -2 6 0
17 13
-5 -1 4 8 -5 -3 -4 7 4 -4 0 8 0 -2 3 2 5

Output
2 3 2
6 5 6 5
8 9 9 10 11


import java.io.*;
import java.util.*;

public class Main {

    static void check(int a[],int n,int k){
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<k;i++){
            hm.put( a[i], hm.getOrDefault(a[i],0) + 1);
        }
        System.out.print(hm.size()+" ");
        for(int i=k;i<n;i++){
            hm.put(a[i-k],hm.get(a[i-k])-1);
            if(hm.get(a[i-k])==0) hm.remove(a[i-k]);
            hm.put(a[i],hm.getOrDefault(a[i],0)+1);
            System.out.print(hm.size()+" ");
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=s.nextInt();
            }
            check(a,n,k);
            System.out.println();
        }
    }
}
