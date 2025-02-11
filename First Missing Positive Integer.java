You are given an array of integers of size N. Find the first positive integer that is missing from the array.

Note: 
 Try solving in O(N) time without using any additional space, except the input array.  Input Format
The first line of input contains T - the number of test cases. For each test case, the first line contains one integer N - the size of the array. The second line contains N integers - the elements of the array.

Output Format
For each test case, print the first missing positive integer, separated by a newline.

Constraints
1 <= T <= 100
1 <= N <= 105
-105 <= A[i] <= 105

Example
Input
2
5
2 0 1 5 -3
6
2 -7 3 1 8 -1

Output
3
4

Explanation

Example 1: The first missing positive integer is 3, as 1 and 2 are present in the array.

import java.io.*;
import java.util.*;

public class Main {
    static int missp(int a[],int n){
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++) hs.add(a[i]);
        for(int i=1;i<=n+1;i++){
            if(!hs.contains(i)) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            System.out.println( missp(a,n));
        }
    }
}
