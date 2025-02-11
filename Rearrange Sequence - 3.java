You are given an array of size N containing integers. Find the size of the largest subarray that can be rearranged to form a contiguous sequence.
A contiguous sequence means that the difference of adjacent elements should be 0 or 1.

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
6
5 2 3 3 1 1
9
8 8 6 7 3 5 7 4 1

Output
5
8

Explanation

Test-Case 1
The largest subarray which can be rearranged to form a contiguous sequence is [2, 3, 3, 1, 1] which can be rearranged to form [1, 1, 2, 3, 3].

Test-Case 2
The largest subarray which can be rearranged to form a contiguous sequence is [8, 8, 6, 7, 3, 5, 7, 4] which can be rearranged to form [3, 4, 5, 6, 7, 7, 8, 8].

import java.io.*;
import java.util.*;

public class Main {

    static int Subseq(int a[],int n){
        int ans=0;
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
            int max=0;
            int min=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                hs.put(a[j],hs.getOrDefault(a[i],0)+1);
                max=Math.max(max,a[j]);
                min=Math.min(min,a[j]);
                if(max-min+1==hs.size()){
                   
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
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
            System.out.println(Subseq(a,n));
        }
    }
}
