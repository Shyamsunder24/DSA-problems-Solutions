You have to complete N jobs using 2 machines. You can only work on 1 job at a time and the jobs should be completed in the order given in the input. The time to complete a particular job is differ	g time of K involved between the machines. Find the minimum time required to complete all the jobs.

Input Format
The first line of input contains T - number of test cases. First line of each testcase contains 2 integers N and K, it is followed by 2 lines, each containing N integers where ith number in each line denotes the time taken by the Machine-1 and Machine-2 to complete the ith job respectively.

Output Format
For each test case, print the minimum time to complete all the jobs, separated by a newline.

Constraints
1 <= T <= 103
1 <= N, K <= 103
1 <= A[i], B[i] <= 105

Example
Input
2
5 8
11 34 50 29 17
36 48 27 13 18
5 2
18 23 44 37 36
46 29 42 45 8

Output
111
132

Explanation

Example 1:
Jobs will be executed in the following order: Machine-1, Machine-1, Machine-2, Machine-2, Machine-2.
Total Cost = 11 + 34 + 8 + 27 + 13 + 18 = 111.

Example 2:
Jobs will be executed in the following order: Machine-1, Machine-1, Machine-1, Machine-1, Machine-2.
Total Cost = 18 + 23 + 44 + 37 + 2 + 8 = 132.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int pa=0,pb=0;
            int ca,cb;
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            String stra[]=br.readLine().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=Integer.parseInt(stra[i]);
            String strb[]=br.readLine().split(" ");
            int b[]=new int[n];
            for(int i=0;i<n;i++) b[i]=Integer.parseInt(strb[i]);
            for(int i=0;i<n;i++){
                ca=Math.min(pa,pb+k)+a[i];
                cb=Math.min(pa+k,pb)+b[i];
                pa=ca;
                pb=cb;
            }
            System.out.println(Math.min(pa,pb));
        }
    }
}
