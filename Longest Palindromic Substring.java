Given a string, find the length of the Longest Palindromic Substring (LPS).

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line has N - the size of the string and the second line contains a string of size N.

Output Format
Print the length of the LPS for each test case, separated by a new line.

Constraints
30 points
1 <= T <= 200
1 <= len(S) <= 100
'a' <= S[i] <= 'z'

70 points
1 <= T <= 200
1 <= len(S) <= 103
'a' <= S[i] <= 'z'

General Constraints
'a' <= S[i] <= 'z'

Example
Input
5
8
pfyafafd
9
sllwffoqq
6
yoogvb
4
hcch
23
mzmqnnrkurfmmfrukrnnqsm

Output
3
2
2
4
18

import java.io.*;
import java.util.*;

public class Main {

    static int palindrome(String str,int n){
        int ans=1;
        for(int i=0;i<n;i++){
            int p1;
            int p2;
            p1=i;
            p2=i+1;
            while(p1>=0 && p2<n && str.charAt(p1)==str.charAt(p2)){
                p1--;
                p2++;
            }
            ans=Math.max(ans,p2-p1-1);
            p1=i-1;
            p2=i+1;
            while(p1>=0 && p2<n && str.charAt(p1)==str.charAt(p2)){
                p1--;
                p2++;
            }
            ans=Math.max(ans,p2-p1-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            String str=s.next();
            System.out.println(palindrome(str,n));
        }
    }
}
