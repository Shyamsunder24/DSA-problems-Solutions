Given a number N, print N!.

Input Format
The first line of input contains T - number of test cases. It's followed by T lines, each containing a single number N.

Output Format
For each test case, print N!. Since the result can be very large, print N! % 1000000007 [1e9+7].

Constraints
1 <= T <= 106
0 <= N <= 106

Example
Input
3
5
20
50

Output
120
146326063
318608048

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int mod=(int)1e9+7;
        long dp[]=new long[(int)1e6+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<((int)1e6+1);i++){
            dp[i]=(dp[i-1]*(i))%mod;
        }
        while(t-->0){
            int n=s.nextInt();
            System.out.println(dp[n]);
        } 
    }
}
