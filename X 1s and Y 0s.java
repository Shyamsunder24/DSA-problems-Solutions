Given two numbers X and Y, find the number whose binary representation has X 1's followed by Y 0's.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines. Each subsequent line contains two integers separated by a space: X - the number of the 1's and Y - the number of 0's which follows the X 1's in the binary representation of the number.

Output Format
For each test case, print the number whose binary representation has X 1's and Y 0's, separated by a new line. Since this number can be very large, print the result % 1000000007.

Constraints
30 points
1 <= T <= 100
0 <= X,Y <= 15

70 points
1 <= T <= 105
0 <= X,Y <= 105

Example
Input
3
4 3
2 5
10 15

Output
120
96
33521664

Explanation

Test-Case 1
The binary representation of the number that has 4 ones followed by 3 zeros is 1111000 = 120.
import java.io.*;
import java.util.*;

public class Main {
    static int mod=(int)(1e9+7);
    private static long powerMod(long b, long e) {
        long result=1;
        b=b%mod;
        while(e>0){
            if((e&1)==1) result=((result%mod)*(b%mod))%mod;
            b=((b%mod)*(b%mod))%mod;
            e>>=1;
        }
        return result;
    }

    public static void main(String[] args) {
        int mod=(int)(1e9+7);
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int i=s.nextInt();
            int j=s.nextInt();
            long ans=((powerMod(2,i+j)%mod)-(powerMod(2,j)%mod)+mod)%mod;
            System.out.println(ans);
        }
    }
}
