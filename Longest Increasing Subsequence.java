100 points
Given an array of size N, find the length of the Longest Increasing Subsequence (LIS).

Input Format
First line of input contains T - number of test cases. Its followed by 2T lines, the first line of each test case contains N - the size of the array and second line contains the elements of the array.

Output Format
For each test case, print the length of the Longest Increasing Subsequence (LIS), separated by newline.

Constraints
100 points
1 <= T <= 100
1 <= N <= 100

100 points
1 <= T <= 103
1 <= N <= 104

General Constraints
-104 <= arr[i] <= 104

Example
Input
3
7
-12 39 -9 72 32 95 -8
4
43 60 15 -5
6
94 19 58 80 14 48

Output
4
2
3

Explanation

Example: Possible LIS of length of 4 is {-12 -9 32 95} or {-12 -9 72 95}

import java.io.*;
import java.util.*;

public class Main {

    // public static int LIS(int a[],int n){
    //     int dp[]=new int[n];
    //     Arrays.fill(dp,1);
    //     int max=0;
    //     for(int i=1;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             if(a[i]>a[j])   dp[i]=Math.max(dp[i],dp[j]+1);
    //         }
    //         max=Math.max(max,dp[i]);
    //     }
    //     return max;
    // }
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1;
        
        // Initialize DP array
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        // Build the DP array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String in[]=br.readLine().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=Integer.parseInt(in[i]);
            System.out.println(lengthOfLIS(a));
        }
    }
}
