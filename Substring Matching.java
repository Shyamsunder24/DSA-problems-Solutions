You are given two strings A and B. You are also given Q queries with 4 indices i, j, k, and l. Check whether the substring of A[i:j] matches the substring of B[k:l].

Input Format
The first line of input contains T - the number of test cases. In each test case, the first line contains the string A and the second line contains the string B.
The next line contains an integer Q - the number of queries. The Q subsequent lines each contain 4 integers i, j, k, and l, separated by a space.

Output Format
For each query, on a new line, print "Yes" if the substring of A matches the substring of B, print "No" otherwise.

Constraints
30 points
1 <= T <= 100
1 <= len(A), len(B) <= 100
0 <= Q <= 1000

120 points
1 <= T <= 100
1 <= len(A), len(B) <= 10000
0 <= Q <= 10000

General Constraints
'a' <= A[i], B[i] <= 'z'
0 <= i <= j < len(A)
0 <= k <= l < len(B)

Example
Input
2
smartinterviews
intermediate
2
5 9 0 4
1 3 2 4
hackerrank
hackerearth
1
0 3 0 3

Output
Yes
No
Yes

Explanation

Test-Case 1
The substring of "smartinterviews" from index 5 to 9 is "inter". The substring of "intermediate" from 0 to 4 is also "inter". Since these both are equal, the output is "Yes".
The substring of "smartinterviews" from index 1 to 3 is "mar". The substring of "intermediate" from 2 to 4 is "ter". Since these both are not equal, the output is "No".

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            String str1=s.next();
            String str2=s.next();
            int n=str1.length();
            int m=str2.length();
            //power array
            int mod=(int)1e9+7;
            long pow[]=new long[Math.max(n,m)+1];
            Arrays.fill(pow,0);
            int p=37;
            pow[0]=1;
            for(int i=1;i<=Math.max(n,m);i++){
                pow[i]=(pow[i-1]*p)%mod;
            }
            //pha and phb
            long pha[]=new long[n];
            long phb[]=new long[m];
            pha[0]=str1.charAt(0)*p;
            for(int i=1;i<n;i++){
                pha[i]=(pha[i-1]+str1.charAt(i)*pow[i+1])%mod;
            }
            phb[0]=str2.charAt(0)*p;
            for(int i=1;i<m;i++){
                phb[i]=(phb[i-1]+str2.charAt(i)*pow[i+1])%mod;
            }
            // querys
            int q=s.nextInt();
            while(q-->0){
                int i=s.nextInt();
                int j=s.nextInt();
                int k=s.nextInt();
                int l=s.nextInt();
                long ha=(pha[j]-(i==0?0:pha[i-1])+mod)%mod;
                long hb=(phb[l]-(k==0?0:phb[k-1])+mod)%mod;
                if(i>k) hb=(hb*pow[i-k])%mod;
                else ha=(ha*pow[k-i])%mod;
                if(ha==hb) System.out.println("Yes");
                else System.out.println("No");
            }
        }
    }
}
