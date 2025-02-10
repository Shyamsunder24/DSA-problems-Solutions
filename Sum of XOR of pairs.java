You are given an array of integers. Find the sum of XOR of all pairs formed by the elements of the array.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Output Format
For each test case, print the sum of XOR of all pairs formed by the elements of the array, separated by a new line.

Constraints
20 points
1 <= T <= 100
1 <= N <= 1000
0 <= A[i] <= 105

80 points
1 <= T <= 100
1 <= N <= 105
0 <= A[i] <= 105

Example
Input
3
3
5 12 8
5
4 10 54 11 8
6
15 35 25 10 15 12

Output
52
560
680

Explanation

Test-Case 1
(5 ^ 5) = 0
(5 ^ 12) = 9
(5 ^ 8) = 13
(12 ^ 5) = 9
(12 ^ 12) = 0
(12 ^ 8) = 4
(8 ^ 5) = 13
(8 ^ 12) = 4
(8 ^ 8) = 0

The sum of all the above xor products = 52
import java.io.*;
import java.util.*;

public class Main {
    static boolean checkbit(int n,int i){
        return ((n>>i)%2)==1;
    }
    static long solve(int a[],int n){
        long ans=0;
        for(int i=0;i<32;i++){
            long set=0;
            for(int j=0;j<n;j++){
                if((a[j]&(1<<i))!=0) set++;
            }
            ans+=(set*(n-set)*(1<<i));
        }
        return 2*ans;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=s.nextInt();
            }
            System.out.println(solve(a,n));
        }
    }
}
