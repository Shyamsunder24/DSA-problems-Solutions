You are given an array of integers of size N. Create a new array such that the element at an index i in the new array is the product of all the elements of the original array except the element present at index i.

Input Format
The first line of input contains T - the number of test cases. For each test case, the first line contains N - the size of the array. The second line contains N integers - the elements of the array.

Output Format
For each test case, print the new array, separated by a new line. Since these numbers can be very large, print the numbers % 109 + 7

Constraints
1 <= T <= 100
2 <= N <= 105
0 <= A[i] <= 105

Example
Input
2
5
1 5 3 2 8
6
4 10 1 2 8 3

Output
240 48 80 120 30
480 192 1920 960 240 640

Explanation

Test-Case 1
The product of all elements of the array except for the element at index 0 is 5 * 3 * 2 * 8 = 240
The product of all elements of the array except for the element at index 1 is 1 * 3 * 2 * 8 = 48
The product of all elements of the array except for the element at index 2 is 1 * 5 * 2 * 8 = 80
The product of all elements of the array except for the element at index 3 is 1 * 5 * 3 * 8 = 120
The product of all elements of the array except for the element at index 4 is 1 * 5 * 3 * 2 = 3

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int mod=(int)1e9+7;
        int t= s.nextInt();
        
        while(t-->0) {
            int N = s.nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = s.nextInt();
            }
            long[] prefix = new long[N];
            long[] suffix = new long[N];
            prefix[0] = 1;
            for (int i = 1; i < N; i++) {
                prefix[i] = (prefix[i - 1] * array[i - 1]) % mod;
            }
            suffix[N - 1] = 1;
            for (int i = N - 2; i >= 0; i--) {
                suffix[i] = (suffix[i + 1] * array[i + 1]) % mod;
            }
            long[] result = new long[N];
            for (int i = 0; i < N; i++) {
                result[i] = (prefix[i] * suffix[i]) % mod;
            }
            for(int i = 0; i < N; i++) System.out.print(result[i]+" ");
            System.out.println();
        }
    }
}
