Given an array of integers, find the maximum subarray sum.

Input Format
The first line of input contains T - number of test cases. It is followed by 2T lines. First line of each test case contains N - size of the array and the second line contains N integers - elements of the array.

Output Format
For each test case, print the maximum subarray sum, followed by the start and end indices of the subarray, separated by new line. If multiple subarrays give the same sum, consider the lexicographically smaller one for the answer.

Constraints
20 points
1 <= T <= 100
1 <= N <= 102

30 points
1 <= T <= 100
1 <= N <= 103

50 points
1 <= T <= 100
1 <= N <= 104

General Constraints
-103 <= A[i] <= 103

Example
Input
3
9
-24 0 28 28 55 -31 -27 -45 -24
10
40 5 39 45 31 -44 73 -16 -31 27
7
57 18 -14 17 31 16 -16

Output
111 1 4
189 0 6
125 0 5

import java.io.*;
import java.util.*;

public class Main {
    public static void maxSubarraySum(int[] arr) {
        int maxSo = arr[0];
        int maxEndingHere = arr[0];
        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxEndingHere + arr[i]) {
                tempStart = i;
                maxEndingHere = arr[i];
            } else {
                maxEndingHere += arr[i];
            }

            if (maxEndingHere > maxSo) {
                maxSo= maxEndingHere;
                start = tempStart;
                end = i;
            }
        }
        System.out.println(maxSo+ " " + (start) + " " + (end ));
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            maxSubarraySum(a);
        }
    }
}
