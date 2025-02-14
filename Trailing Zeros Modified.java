Given an integer N, print the number of positive integers whose factorial ends with N 0's.

Input Format
The first line of input contains T - number of test cases. Its followed by T lines, each containing an integer N.

Output Format
For each test case, print the number of positive integers whose factorial ends with N 0's, separated by newline.

Constraints
30 points
1 <= T <= 100
0 <= N <= 104

70 points
1 <= T <= 1000
0 <= N <= 1014

Example
Input
3
1
5
2

Output
5
0
5

Explanation

Test Case 1:
The positive integers whose factorial ends with one 0 are: 5, 6, 7, 8, 9

Test Case 2:
There are no positive integers whose factorial ends with five 0's.

Test Case 3:
The positive integers whose factorial ends with two 0's are: 10, 11, 12, 13, 14

import java.io.*;
import java.util.*;

public class Main {
    public static long Trailing(long x){
        long c=0;
        while(x>0){
            x/=5;
            c+=x;
        }
        return c;
    }
    public static long Count(long n){
        long lo=1;
        long hi=5L*(n+1);
        long res=0;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            long z=Trailing(mid);
            if(z<n){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        if(Trailing(lo)!=n)return 0;
        long first=lo;
        long last=lo;
        while(Trailing(last+1)==n){
            last++;
        }
        return (last-first+1);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n=sc.nextLong();
            System.out.println(Count(n));
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
    }
}
