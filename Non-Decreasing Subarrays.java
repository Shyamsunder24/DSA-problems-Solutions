Given an array of integers of size N, count the number of subarrays of given array which are non-decreasing.

Input Format
First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - size of the array and second line contains the elements of the array.

Output Format
For each test case, print the count of number of subarrays which are non-decreasing, separated by newline.

Constraints
10 points
1 <= T <= 100
1 <= N <= 102

20 points
1 <= T <= 100
1 <= N <= 103

70 points
1 <= T <= 100
1 <= N <= 105

General Constraints
1 <= arr[i] <= 109

Example
Input
3
6
2 3 1 4 6 6
1
5
3
1 3 2

Output
13
1
4

Explanation

Test Case 1:
All the valid subarrays are: [2], [2,3], [3], [1], [1,4], [1,4,6], [1,4,6,6], [4], [4,6], [4,6,6], [6], [6,6], [6]

Test Case 2:
All the valid subarrays are: [5]

Test Case 3:
All the valid subarrays are: [1], [1,3], [3], [2]

import java.io.*;
import java.util.*;

public class Main {

    public static long sub(int[] arr, int n){
        long dp=1;
        long ans=dp;
        for(int i=1;i<n;i++){
            if(arr[i]>=arr[i-1]){
                dp+=1;
            }else{
                dp=1;
            }
            ans=(ans+dp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++) arr[i]=sc.nextInt();

            System.out.println(sub(arr,n));
        }

    }
}
