You have a collection of N rods. Each rod has a unique mark on it. You are given the lengths of each rod. You have to tell how many different triangles can be formed using these rods.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the number of rods. The second line contains the lengths of the rods.

Output Format
For each test case, print the total number of different triangles possible, separated by new line.

Constraints
30 points
1 <= T <= 100
1 <= N <= 100
1 <= A[i] <= 100000

70 points
1 <= T <= 100
1 <= N <= 1000
1 <= A[i] <= 100000

Example
Input
2
6
20 67 72 83 23 59
6
4 2 10 12 8 10

Output
14
10

import java.io.*;
import java.util.*;

public class Main {
    static void printtriangles(int n,int a[]){
        Arrays.sort(a);
        int ans=0;
        for(int i=0;i<n-2;i++){
            int k=i+2;
            for(int j=i+1;j<n;j++){
                while(k<n&& a[i]+a[j]>a[k]) k++;
                ans+=k-j-1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            printtriangles(n,a);
        }
    }
}
