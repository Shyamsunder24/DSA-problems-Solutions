You are given the heights of N buildings. All the buildings are of width 1 and are adjacent to each other with no empty space in between. Assume that it is raining heavily, and as such water will be accumulated on top of certain buildings. Your task is to find the total amount of water accumulated.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the number of buildings. The second line contains N elements denoting the height of the buildings.

Output Format
For each test case, print the units of water accumulated, separated by a new line.

Constraints
30 points
1 <= T <= 1000
1 <= N <= 1000
1 <= a[i] <= 1000

70 points
1 <= T <= 1000
1 <= N <= 100000
1 <= a[i] <= 1000

Example
Input
2
7
1 6 2 4 5 7 9 
5
3 2 7 4 7 

Output
7
4

Explanation

Test-Case 1
Water accumulated on top of Building-1 : 0
Water accumulated on top of Building-2 : 0
Water accumulated on top of Building-3 : 4
Water accumulated on top of Building-4 : 2
Water accumulated on top of Building-5 : 1
Water accumulated on top of Building-6 : 0
Water accumulated on top of Building-7 : 0
Total = 0 + 0 + 4 + 2 + 1 + 0 + 0 = 7

Test-Case 2
Water accumulated on top of Building-1 : 0
Water accumulated on top of Building-2 : 1
Water accumulated on top of Building-3 : 0
Water accumulated on top of Building-4 : 3
Water accumulated on top of Building-5 : 0
Total = 0 + 1 + 0 + 3 + 0 = 4

import java.io.*;
import java.util.*;

public class Main {

    static int cwater(int a[],int n){
        int ans=0;
        int lmax[]=new int[n];
        int rmax[]=new int[n];
        lmax[0]=a[0];
        for(int i=1;i<n;i++) lmax[i]=Math.max(lmax[i-1],a[i]);
        rmax[n-1]=a[n-1];
        for(int i=n-2;i>=0;i--) rmax[i]=Math.max(rmax[i+1],a[i]);
        for(int i=1;i<n-1;i++){
            ans+=(Math.min(lmax[i],rmax[i])-a[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            System.out.println(cwater(a,n));
        }
    }
}
