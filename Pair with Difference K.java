You are given an integer array and an integer K. You have to tell if there exists a pair of integers in the given array such that ar[i]-ar[j]=K and i≠j.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N and K - the size of the array and the number K. The second line contains the elements of the array.

Output Format
For each test case, print "true" if the arrays contains such elements, "false" otherwise, separated by new line.

Constraints
40 points
2 <= N <= 1000

60 points
2 <= N <= 100000

General Constraints
1 <= T <= 100
-105 <= ar[i], K <= 105

Example
Input
2
5 60
1 20 40 100 80
10 11
12 45 52 65 21 645 234 14 575 112

Output
true
false

import java.io.*;
import java.util.*;

public class Main {
    static void mergesort(int a[],int n,int low,int high){
        if(low==high) return;
        int mid=(low+high)/2;
        mergesort(a,n,low,mid);
        mergesort(a,n,mid+1,high);
        merge(a,n,low,mid,high);
    }

    static void merge(int a[],int n,int low,int mid,int high){
        int temp[]=new int[high-low+1];
        int p=0;
        int p1=low;
        int p2=mid+1;
        while(p1<=mid && p2<=high){
            if(a[p1]<a[p2]) temp[p++]=a[p1++];
            else temp[p++]=a[p2++];
        }
        while(p1<=mid) temp[p++]=a[p1++];
        while(p2<=high) temp[p++]=a[p2++];
        for(int i=low;i<=high;i++) a[i]=temp[i-low];
    }

    static boolean check(int a[],int n,int k){
        int p1=0;
        int p2=0;
        while(p1<n &&p2<n){
            int sum=a[p1]-a[p2];
            if(sum==k) return true;
            else if(sum>k) p2++;
            else p1++;
        }
        return false;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            mergesort(a,n,0,n-1);
            boolean b=check(a,n,k);
            if(b) System.out.println("true");
            else System.out.println("false");
        }
    }
}
