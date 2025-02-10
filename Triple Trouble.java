Given an array of size 3X+1, where every element occurs three times, except one element, which occurs only once. Find the element that occurs only once.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the size of the array (of the form 3X + 1) and second line contains the elements of the array.

Output Format
For each test case, print the number which occurs only once, separated by new line.

Constraints
30 points
1 <= T <= 100
1 <= N <= 103
1 <= A[i] <= 105

70 points
1 <= T <= 100
1 <= N <= 106
1 <= A[i] <= 109

Example
Input
2
10
5 7 8 7 7 9 5 9 5 9
7
10 20 20 30 20 30 30

Output
8
10

import java.io.*;
import java.util.*;

public class Main {
    static boolean checkbit(int n,int i){
        return((n>>i)%2)==1;
    }
    static int solve(int a[],int n){
        int ans=0;
        for(int i=0;i<31;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(checkbit(a[j],i)){
                    count++;
                }
            }
            if(count%3!=0){
                ans=ans+(1<<i);
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
            System.out.println(solve(a,n));
        }
    }
}
