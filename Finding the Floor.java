Given an array, you have to find the floor of a number x. The floor of a number x is nothing but the largest number in the array less than or equal to x.

Input Format
The first line of input contains the N - the size of the array. The next line contains N integers, the elements of the array. The next line contains Q - number of queries. Each of the next Q lines contains a single integer X, for which you have to find the floor of X in the given array.

Output Format
For each query, print the floor of X, separated by a new line. If the floor is not found, print the value of "INT_MIN".

Constraints
30 points
1 <= N <= 105
1 <= Q <= 102
-108 <= ar[i] <= 108

70 points
1 <= N <= 105
1 <= Q <= 105
-108 <= ar[i] <= 108

Example
Input
6
-6 10 -1 20 15 5
5
-1
10
8
-10
-4

Output
-1
10
5
-2147483648
-6

import java.io.*;
import java.util.*;

public class Main {
    static void mergersort(int a[],int n,int low,int high){
        if(low==high) return;
        int mid=(low+high)/2;
        mergersort(a,n,low,mid);
        mergersort(a,n,mid+1,high);
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

    static int BSFloor(int a[],int n,int k){
        int ans=Integer.MIN_VALUE;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(a[mid]<=k){
                ans=a[mid];
                low=mid+1;
            }
            else high=mid-1;
        }
        return ans;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=s.nextInt();
        mergersort(a,n,0,n-1);
        int t=s.nextInt();
        while(t-->0){
            int k=s.nextInt();
            System.out.println(BSFloor(a,n,k));
        }
    }
}
