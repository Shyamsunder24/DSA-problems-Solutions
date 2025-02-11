Given an array of integers, answer queries of the form: [i, j]: Print the sum of array elements from A[i] to A[j], both inclusive.

Input Format
The first line of input contains the N-size of the array. The next line contains N integers - elements of the array. The next line contains Q - number of queries. Each of the next Q lines contains 2 space-separated indexes: i and j.

Output Format
For each query, print the sum of array elements from A[i] to A[j], both inclusive, separated by a new line.

Constraints
30 points
1 <= N, Q <= 10000

70 points
1 <= N, Q <= 500000

General Constraints
-109 <= A[i] <= 109
0 <= i <= j <= N-1

Example
Input
10
1 30 13 -4 -5 12 -53 -12 43 100
4
0 5
1 7
2 3
7 9

Output
47
-19
9
131

import java.io.*;
import java.util.*;

public class Main {
    static void sumsub(long a[],int n,int i,int j){    
        if(i!=0) System.out.println(a[j]-a[i-1]);
        else System.out.println(a[j]);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        long a[]=new long[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextLong();
        }
        for(int i=1;i<n;i++){
            a[i]=a[i-1]+a[i];
        }
        int t=s.nextInt();
        while(t-->0){
            int i=s.nextInt();
            int j=s.nextInt();
            sumsub(a,n,i,j);
        }
    }
}
