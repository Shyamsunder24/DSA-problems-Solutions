Given a set of non-negative integers, and a value S, determine if there is a subset of the given set with sum equal to S.

Input Format
The first line of the input contains T - the number of test cases. It is followed by 2T lines - the first line of each test case contains N - number of elements in given array and S - the required sum. The second line contains elements of the array.

Output Format
For each test case, print "YES" if there is a subset of the given set with sum equal to given S, otherwise "NO", separated by new line .

Constraints
30 points
1 <= N <= 10
0 <= S <= 100

120 points
1 <= N <= 100
0 <= S <= 1000

General Constraints
1 <= T <= 100
0 <= A[i] <= 103

Example
Input
2
5 15
10 4 5 9 1
5 17
13 11 19 20 21

Output
YES
NO

Explanation

Example 1:
15 = 9 + 5 + 1

Example 2:
No such subset exists.
import java.io.*;
import java.util.*;

public class Main {
    public static boolean subSum(int [] arr,int n,int k){
        long z=1<<n;
        for(int i=0;i<z;i++){
            int sum=0;int temp=i;
            int j=0;
            while(temp>0){
                if((temp & 1)==1)
                    sum+=arr[j];
                j++;
                temp=temp>>1;
            }
            if(sum==k)
                return true;
        }
            return false;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            int arr[]=new int[n+1];
            for(int i=1;i<=n;i++) arr[i]=s.nextInt();

            boolean dp[][]=new boolean[n+1][k+1];
            dp[0][0]=true;
            // for(int i=1;i<=n;i++){
            //     for(int j=1;j<=k;j++){
            //         if(j>=a[i])
            //             dp[i][j]= dp[i-1][j-a[i]] || dp[i-1][j];
            //         else
            //             dp[i][j]=dp[i-1][j];
            //     }
            // }
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    if (arr[i - 1] > j) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
            System.out.println((dp[n][k])?"YES":"NO");
        }
    }
}
