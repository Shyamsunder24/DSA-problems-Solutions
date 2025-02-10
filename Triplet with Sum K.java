You are given an integer array and a positive integer K. You have to tell if there exists i,j,k in the given array such that ar[i]+ar[j]+ar[k]=K, i≠j≠k.

Input Format
The first line of input contains T - the number of test cases. Its followed by 2T lines, the first line contains N and K - the size of the array and the number K. The second line contains the elements of the array.

Output Format
For each test case, print "true" if the arrays contains such elements, "false" otherwise, separated by new line.

Constraints
30 points
1 <= T <= 100
3 <= N <= 100

70 points
1 <= T <= 100
3 <= N <= 1000

General Constraints
-105 <= A[i] <= 105
0 <= K <= 105

Example
Input
3
5 60
1 20 40 100 80
12 54
12 45 52 65 21 645 234 -100 14 575 -80 112
3 15
5 5 5

Output
false
true
true

import java.io.*;
import java.util.*;

public class Main {
    static boolean triplecheck(int a[],int n,int k){
        for(int i=0;i<n-2;i++){
            int sum=k-a[i];
            int p1=i+1;
            int p2=n-1;
            while(p1<=p2){
                int f=a[p1]+a[p2];
                if(f==sum) return true;
                else if(f<sum) p1++;
                else p2--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            int a[]=new int[n];
            boolean b=false;
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            Arrays.sort(a);
            if(triplecheck(a,n,k)) System.out.println("true");
            else System.out.println("false");
        }
    }
}
