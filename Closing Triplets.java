Given three arrays A, B, and C, choose a triplet a, b, c such that a, b, and c belong to the arrays A, B, and C respectively, such that the absolute difference between the maximum and minimum element of the chosen triplet is minimized, i.e., minimize |max(a,b,c)-min(a,b,c)|.

Input Format
The first line of input contains T - the number of test cases. It is followed by 6T lines, the first line contains N1 - the size of the array A and the second line contains the elements of the array A. The third line contains N2 - the size of the array B and the fourth line contains the elements of the array B. The fifth line contains N3 - the size of the array C and the sixth line contains the array C elements.

Output Format
For each test case, print the minimum absolute difference, separated by a newline.

Constraints
10 points
1 <= T <= 100
1 <= N1, N2, N3 <= 100
0 <= A[i], B[i], C[i] <= 109

30 points
1 <= T <= 100
1 <= N1 ,N2, N3 <= 500
0 <= A[i], B[i], C[i] <= 109

60 points
1 <= T <= 100
1 <= N1, N2, N3 <= 10000
0 <= A[i], B[i], C[i] <= 109

Example
Input
1
5
10 8 5 4 1
3
6 9 15
4
8 3 2 6

Output
1

Explanation

Example 1: The triplet (5,6,6) belongs to the arrays A, B, and C respectively and it gives |max(a,b,c)-min(a,b,c)| = 1.

import java.io.*;
import java.util.*;

public class Main {

    static long cltrip(int n1,int n2,int n3,long a[],long b[],long c[]){
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int p1=0, p2=0, p3=0;
        long ans=Integer.MAX_VALUE;
        long diff=0;
        while(p1<n1 && p2<n2 && p3<n3){
            diff=Math.abs(Math.max(a[p1],Math.max(b[p2],c[p3]))-Math.min(a[p1],Math.min(b[p2],c[p3])));
            ans=Math.min(ans,diff);
            long min=Math.min(a[p1],Math.min(b[p2],c[p3]));
            if(a[p1]==min) p1++;
            else if(b[p2]==min) p2++;
            else p3++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n1=s.nextInt();
            long a[]=new long[n1];
            for(int i=0;i<n1;i++) a[i]=s.nextLong();
            int n2=s.nextInt();
            long b[]=new long[n2];
            for(int i=0;i<n2;i++) b[i]=s.nextLong();
            int n3=s.nextInt();
            long c[]=new long[n3];
            for(int i=0;i<n3;i++) c[i]=s.nextLong();
            System.out.println(cltrip(n1,n2,n3,a,b,c));
        }
    }
}
