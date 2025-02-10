Count Set Bits bookmark_borderGiven a number N, find the number of bits that are set to 1 in its binary representation.

Input Format
The first line of input contains T - the number of test cases. It is followed by T lines, each line contains a single integer N.

Output Format
For each test case, print the number of bits set to 1 in the binary representation of N, separated by a new line.

Constraints
1 <= T <= 104
0 <= N <= 1018

Example
Input
3
4
15
10

Output
1
4
2

Explanation

Test-Case 1
The binary representation of 4 is 100.
The number of 1's in the binary representation of 4 is 1.

Test-Case 2
The binary representation of 15 is 1111.
The number of 1's in the binary representation of 15 is 4.
  import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            long n=s.nextLong();
            int cnt=0;
            while(n!=0){
                if((n&1)==1){
                cnt++;
                }
                n=(n>>1);
            }
            System.out.println(cnt);
        }
    }
}
