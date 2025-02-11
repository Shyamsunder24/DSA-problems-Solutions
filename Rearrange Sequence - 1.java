You are given an array of size N containing unique integers. Find the size of the largest subarray that can be rearranged to form a contiguous sequence.
A contiguous sequence means that the difference of adjacent elements should be 1.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Output Format
For each test case, print the size of the largest subarray that can be rearranged to form a contiguous sequence, on a new line.

Constraints
30 points
1 <= T <= 100
4 <= N <= 100

70 points
1 <= T <= 100
4 <= N <= 1000

General Constraints
0 <= A[i] <= 105

Example
Input
2
5
1 3 2 6 5
9
0 8 6 5 7 10 3 2 1

Output
3
4

Explanation

Test-Case 1
The largest subarray that can be rearranged to form a contiguous sequence is [1, 3, 2] which can be rearranged to form [1, 2, 3].

Test-Case 2
The largest subarray that can be rearranged to form a contiguous sequence is [8, 6, 5, 7] which can be rearranged to form [5, 6, 7, 8].

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int a[] = new int[n];
            int i=0;
            for(i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            //Arrays.sort(a);
            int res=0;
            int j=0;
            for(i=0;i<n;i++){
            int min = a[i];
            int max = a[i];
            
            for(j=i;j<n;j++){
                
                min = Math.min(min,a[j]);
                max = Math.max(max,a[j]);
                if((max-min)==j-i){
                    res = Math.max(res,j-i+1);
                }
            }
                
            }
            System.out.println(res);
            t--;
        }
    }
}
