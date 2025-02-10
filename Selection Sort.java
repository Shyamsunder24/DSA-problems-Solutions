Implement Selection Sort and print the index which gets swapped at each step.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the size of the array. The next line contains N integers - elements of the array.

Output Format
For each test case, print the index which gets swapped at each step, separated by space. Separate the output of different tests by a new line.

Constraints
1 <= T <= 100
2 <= N <= 100
-1000 <= ar[i] <= 1000

Example
Input
6
8
176 -272 -272 -45 269 -327 -945 176
2
-274 161
7
274 204 -161 481 -606 -767 -351
2
154 -109
4
5 3 1 5
4
40 10 20 40

Output
4 0 4 3 1 2 1
1
3 0 1 2 2 1
0
0 0 1
0 0 0

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            selectionSort(n,a);
            System.out.println();
        }
    }
    static void selectionSort(int n,int a[]){
        for(int i=n-1;i>0;i--){
            int max=i;
            for(int j=0;j<i;j++){
                if(a[max]<a[j]){
                    max=j;
                }
                else if(a[max]==a[j]&&max>j){
                    max=j;
                }}
                
                    int temp=a[i];
                    a[i]=a[max];
                    a[max]=temp;
                    System.out.print(max+" ");
            }
        }
}
