Look at the following sequence:
3, 5, 6, 9, 10, 12, 17, 18, 20....
All the numbers in the series have exactly 2 bits set in their binary representation. Your task is simple, you have to find the Nth number of this sequence.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each containing a single number N.

Output Format
For each test case, print the Nth number of the sequence, separated by a newline. Since the number can be very large, print the number % 1000000007.

Constraints
30 points 
1 <= T, N <= 200

70 points 
1 <= T, N <= 105

100 points 
1 <= T <= 105
1 <= N <= 1014

Example
Input
5
1
2
5
50
100

Output
3
5
10
1040
16640

import java.io.*;
import java.util.*;

public class Main {
    static long aPowerB(long b) {
        long mod = (long) 1e9 + 7;
        long a = 2, ans = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ((ans % mod) * (a % mod)) % mod;
            }
            a = ((a % mod) * (a % mod)) % mod;
            b = b >> 1;
        }

        return ans;
    }
    static long getNthNumber(long n) {
        long mod = (long) 1e9 + 7;
        n = n % mod;
        int count = 0;

        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < i; j++) {
                count++;
                if (count == n) {
                    long ans = ((aPowerB(i) % mod) + (aPowerB(j) % mod)) % mod;
                    return ans % mod;
                }
            }
        }

       return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int t = sc.nextInt() ;

        while(t-- > 0){
            long n = sc.nextLong();
            long ans = getNthNumber(n);
            System.out.println(ans);
        }

    }
}
