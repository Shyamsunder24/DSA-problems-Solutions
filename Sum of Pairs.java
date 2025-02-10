Given an array of integers and a number K, check if there exist a pair of indices i,j s.t. a[i] + a[j] = K and i!=j.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, first line of each test case contains N - the size of the array and K, and the next line contains N space separated integers - the elements of the array.

Output Format
For each test case, print "True" if such a pair exists, "False" otherwise, separated by newline.

Constraints
30 points
1 <= T <= 100
2 <= N <= 1000

70 points
1 <= T <= 300
2 <= N <= 10000

General Constraints
-108 <= K <= 108
-108 <= ar[i] <= 108

Example
Input
3
5 -15
-30 15 20 10 -10
2 20
10 10
4 7
-4 0 10 -7

Output
True
True
False

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
        int p2=n-1;
        while(p1<p2){
            int sum=a[p1]+a[p2];
            if(sum==k) return true;
            else if(sum>k) p2--;
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
            if(b) System.out.println("True");
            else System.out.println("False");
        }
        
    }
}
