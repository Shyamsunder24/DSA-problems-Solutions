Given 2 numbers - A and B, evaluate AB.

Note: 
 Do not use any inbuilt functions / libraries for your main logic.  Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each line containing 2 numbers - A and B, separated by space.

Output Format
For each test case, print AB, separated by new line. Since the result can be very large, print result % 1000000007

Constraints
30 points
1 <= T <= 1000
0 <= A <= 106
0 <= B <= 103

70 points
1 <= T <= 1000
0 <= A <= 106
0 <= B <= 109

Example
Input
4
5 2
1 10
2 30
10 10

Output
25
1
73741817
999999937
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int t = sc.nextInt() ;
        while(t-- > 0){
            int a = sc.nextInt() ;
            int b = sc.nextInt() ;
            long ans = 1 ;
            long mod = (long) 1e9 + 7 ;
            while(b > 0){
                if( (b & 1) == 1 ){
                    ans = (long) ((ans % mod)  * (a % mod) ) % mod ;
                }
                a = a * a ;
                b = b >> 1 ;
            }
            System.out.println(ans) ;
        }
    }
}
