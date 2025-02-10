You are given an array of 0's and 1's. Sort the array in ascending order and print it.

Note: 
 Solve using two-pointer technique.  Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Output Format
For each test case, sort the array in ascending order and print it in a new line.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= A[i] <= 1

Example
Input
2
5
0 1 1 0 1
6
1 1 1 1 1 0

Output
0 0 1 1 1
0 1 1 1 1 1

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            int p1=0,p2=0;
            for(int i=0;i<n;i++){
                if(a[i]==1) p1++;
                else p2++;
            } 
            for(int i=0;i<p2;i++) System.out.print(0+" ");
            for(int i=0;i<p1;i++) System.out.print(1+" ");
            System.out.println();
        }
    }
}
