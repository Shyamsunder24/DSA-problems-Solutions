Given an array, find the length of the longest subsequence whose elements can be re-arranged in a strictly increasing contiguous order. The difference between 2 adjacent elements in the subsequence, after re-arrangement, should be exactly 1.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - size of the array. The next line contains N integers - the elements of the array.

Output Format
For each test case, print the length of the longest subsequence, separated by a new line.

Constraints
1 <= T <= 1000
1 <= N <= 10000
-100000 <= ar[i] <= 100000

Example
Input
3
8
21 -22 -22 5 -31 -24 5 -23
10
18 -33 31 33 30 -14 32 30 16 17
6
6 3 8 5 2 5

Output
3
4
2

Explanation

Test Case-1:
Subsequence is: -22, -24, -23.

Test Case-2: 
Subsequence is: 31, 33, 30, 32.

Test Case-3: 
Subsequence is: 6, 5 or 3, 2.

import java.io.*;
import java.util.*;

public class Main {

    static int subseq(int a[],int n,HashSet<Integer> hs){
        // Arrays.sort(a);
        // int max=0;
        // int cl=0;
        // for(int i=1;i<n;i++){
        //     if(a[i]==a[i-1]+1) cl++;
        //     else if(a[i]!=a[i-1]){
        //         max=Math.max(max,cl);
        //         cl=1;
        //     }
        // }
        // return Math.max(max,cl);
        int ans=0;
        for(int no: hs){

            if(!hs.contains(no-1)){
                int c=no;
                int le=1;
                while(hs.contains(c+1)){
                    c++;
                    le++;
                }
                ans=Math.max(ans,le);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        InputStreamReader is=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(is);
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int a[]=new int[n];
            String s[]=br.readLine().split(" ");
            HashSet<Integer> hs=new HashSet<>();
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
                hs.add(a[i]);
            }
            System.out.println(subseq(a,n,hs));
        }
    }
}
