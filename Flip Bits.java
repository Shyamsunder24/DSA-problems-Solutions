You are given two numbers A and B. Write a program to count the number of bits to be flipped to change the number A to the number B. Flipping a bit of a number means changing a bit from 1 to 0 or vice versa.

Input Format
The first line of input contains T - the number of test cases. Each of the next T lines contains 2 integers A and B, separated by space.

Output Format
For each test case, print the number of bit flips required to convert A to B, separated by a new line.

Constraints
1 <= T <= 100000
0 <= A, B <= 109

Example
Input
4
20 10
16 8
1 153
549 24

Output
4
2
3
6
import java.io.*;
import java.util.*;

public class Main {
    static int solve(int a,int b){
        long n=(a^b);
        int cnt=0;
        while(n!=0){
            if((n&1)==1){
                cnt++;
            }
            n=n>>1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int a=s.nextInt();
            int b=s.nextInt();
            System.out.println(solve(a,b));
        }
    }
}
