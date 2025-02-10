Find the cube root of the given number. Assume that all the input test cases will be a perfect cube.

Note: Do not use any inbuilt functions / libraries for your main logic.  Input Format
The first line of input contains T - the number of test cases. It is followed by T lines, each containing a single integer.

Output Format
For each test case, print the cube root of the number, separated by a new line.

Constraints
30 points
1 <= T <= 103
-109 <= N <= 109

70 points
1 <= T <= 106
-1018 <= N <= 1018

Example
Input
5
-27
-125
1000
6859
-19683

Output
-3
-5
10
19
-27

import java.io.*;
import java.util.*;

public class Main {
    static long check(long n,long l,long h){
        long ans=0;
        long low=l;
        long high=h;
        while(low<=high){
            long mid=(low+high)/2;
            if(mid*mid*mid<=n){
                ans=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            long n=s.nextLong();
            long x=(long)Math.pow(10,6);
            if(n>0) System.out.println(check(n,0,x));
            else System.out.println(check(n,x*-1,0));
        }
    }
}
