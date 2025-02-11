You are given an array of size N containing integers which may not be unique. Find the size of the largest subarray that can be rearranged to form a strictly contiguous sequence.

Input Format
The first line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

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
4 3 3 1 1
9
8 8 6 7 3 5 7 1 1

Output
2
3

Explanation

Test-Case 1
The largest subarray which can be rearranged to form a contiguous sequence here, is {4, 3} which can be rearranged to form {3, 4}.

Test-Case 2
The largest subarray which can be rearranged to form a contiguous sequence here, is {8, 6, 7} which can be rearranged to form {6, 7, 8}.

import java.io.*;
import java.util.*;

public class Main {

    static int Subseq(int a[],int n){
        int ans=0;
        for(int i=0;i<n;i++){
            HashSet<Integer> hs=new HashSet<Integer>();
            int min=Integer.MAX_VALUE;
            int max=0;
            for(int j=i;j<n;j++){
                if(!hs.contains(a[j])) hs.add(a[j]);
                else break;
                max=Math.max(max,a[j]);
                min=Math.min(min,a[j]);
                if(max-min+1==hs.size()){
                    ans=Math.max(ans,hs.size());
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
