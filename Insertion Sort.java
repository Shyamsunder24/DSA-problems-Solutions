Implement Insertion Sort and print the index at which the ith element gets inserted [i>=1].

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the size of the array. The next line contains N integers - elements of the array.

Output Format
For each test case, print the index at which the ith element gets inserted [i>=1], separated by space. Separate the output of different tests by a new line.

Constraints
1 <= T <= 100
2 <= N <= 100
-1000 <= ar[i] <= 1000

Example
Input
4
8
176 -272 -272 -45 269 -327 -945 176
2
-274 161
7
274 204 -161 481 -606 -767 -351
2
154 -109

Output
0 1 2 4 0 0 6
1
0 0 3 0 0 2
0

import java.io.*;
import java.util.*;

public class Main {
    public static void insertionSort(int arr[],int n){
        for(int i=1;i<n;i++){
            int j=i-1;
            int temp=arr[i];
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=temp;
            System.out.print((j+1)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while(T-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            insertionSort(arr,n);
        }
        
    }
}
