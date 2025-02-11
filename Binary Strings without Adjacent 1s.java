Find the number of binary strings of length N, such that there are no adjacent 1s in that string.

Input Format
The first line of input contains T - number of test cases. It is followed by T lines, each line contains N - length of the binary string.

Output Format
For each test case, print the number of binary strings of length N, separated by new line. Since the answer can be very large, print answer % 1000000007 [1e9+7].

Constraints
1 <= T <= 105
1 <= N <= 105

Example
Input
5
3
11
7
5
500

Output
5
233
34
13
73724597

Explanation

Example 1:
You can construct the following binary strings of length 3 with no adjacent 1s:
000, 001, 010, 100, 101

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int mod=(int)1e9+7;
        int dp0[]=new int[(int)1e5+1];
        int dp1[]=new int[(int)1e5+1];
        dp0[1]=1;
        dp1[1]=1;
        for(int i=2;i<((int)1e5+1);i++){
            dp0[i]=(dp0[i-1]+dp1[i-1])%mod;
            dp1[i]=(dp0[i-1])%mod;
        }
        while(t-->0){
            int n=s.nextInt();
            System.out.println((dp0[n]+dp1[n])%mod);
        }    
    }
}
