Given two numbers X and Y, find the number whose binary representation has its Xth and Yth bits set to 1 and remaining bits set to 0.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines. Each subsequent line contains two integers: X - the index of the first set bit and Y - the index of the second set bit, separated by a space.

Output Format
For each test case, print the number whose binary representation has its Xth and Yth bits set to 1 and the remaining bits set to zero, separated by a new line.
Since this number can be very large, print the result % 1000000007.

Constraints
30 points
1 <= T <= 100
0 <= X,Y <= 30

70 points
1 <= T <= 105
0 <= X,Y <= 105

Example
Input
3
4 3
5 0
15 30

Output
24
33
73774585

Explanation

Test-Case 1
The binary representation of the number that has bits at position 3 and 4 set is 11000 = 24

Test-Case 2
The binary representation of the number that has the bit at position 5 and 0 set is 100001 = 33
import java.io.*;
import java.util.*;

public class Main {
    private static final int mod= 1000000007;
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
    public static long xnady(long a,long b){
        return (powerMod(2,a)==powerMod(2,b))?powerMod(2,a):((powerMod(2,a)%mod+powerMod(2,b)%mod)%mod);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str[]=br.readLine().split(" ");
            int X = Integer.parseInt(str[0]);
            int Y = Integer.parseInt(str[1]);
            // long a=powerMod(2,X)%mod;
            // long b=powerMod(2,Y)%mod;
            // long ans=0;
            // if(a!=b) ans=((a%mod)|(b%mod)%mod);
            // else ans=a%mod;
            System.out.println(xnady(X,Y));
        }
    }
}
