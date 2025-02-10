Implement Bubble Sort and print the total number of swaps involved to sort the array.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the size of the array. The next line contains N integers - the elements of the array.

Output Format
For each test case, print the total number of swaps, separated by a new line.

Constraints
1 <= T <= 100
1 <= N <= 100
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
15
0
16
1


import java.io.*;
import java.util.*;

public class Main {
    static int bubblesort(int a[],int n){
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            System.out.println(bubblesort(a,n));
        }
    }
}
