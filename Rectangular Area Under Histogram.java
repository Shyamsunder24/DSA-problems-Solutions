Given the height of adjacent buildings, find the largest rectangular area possible, where the largest rectangle can be made of a number of contiguous buildings. For simplicity, assume that all buildings have the same width and the width is 1 unit.
Note that the sides of the rectangle have to be parallel to the axes.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines - the first line contains N - the number of buildings. The second line contains the height of the buildings.

Output Format
For each test case, print the area of the largest possible rectangle, separated by a newline.

Constraints
50 points
1 <= T <= 100
1 <= N <= 103
1 <= A[i] <= 1000

100 points
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 104

Example
Input
2
7
6 2 5 4 5 1 6
4
5 10 12 4

Output
12
20

Explanation

Example 1:
You can form the following rectangles:
6x1 = 6, 2x5 = 10, 5x1 = 5, 4x3 = 12, 5x1 = 5, 1x7 = 7, 6x1 = 6 : max = 12 [axb means rectangle with height a and width b]

Example 2:
You can form the following rectangles:
5x3 = 15, 10x2 = 20, 12x1 = 12, 4x4 = 16 : max = 20 [axb means rectangle with height a and width b]

import java.io.*;
import java.util.*;

public class Main {
    static int[] nsr(int a[],int n){
        int r[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && a[i]<=a[st.peek()]) {
                st.pop();
            }
            r[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return r;
    }
    static int[] nsl(int a[],int n){
        Stack<Integer> st=new Stack<>();
        int l[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[i]<=a[st.peek()]) {
                st.pop();
            }
            l[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return l;
    }

    static long areahistogram(int a[],int n){
        int[] r=nsr(a,n);
        int[] l=nsl(a,n);
        // System.out.println(Arrays.toString(r));
        // System.out.println(Arrays.toString(l));
        long ans=0;
        for(int i=0;i<n;i++){
             ans=Math.max(ans,(r[i]-l[i]-1)*a[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            System.out.println(areahistogram(a,n));
        }
    }
}
