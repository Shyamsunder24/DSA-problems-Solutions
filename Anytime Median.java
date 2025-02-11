Given an integer array, print the median for the sub-array 0 to i, for every i, 0 <= i <= N-1.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines - the first line contains N - the size of the array. The second line contains N integers - the elements of the array.

Output Format
For each test case, print the median for the sub-array 0 to i, for every i, separated by space. Print a new line between the output of different test cases. Note that in the case of even length sub-array, print the smaller element as the median.

Constraints
30 points
1 <= T <= 100
1 <= N <= 103

70 points
1 <= T <= 100
1 <= N <= 104

General Constraints
-104 <= A[i] <= 104

Example
Input
2
5
-10 14 11 -5 7 
3
2 -5 14 

Output
-10 -10 11 -5 7 
2 -5 2 

import java.io.*;
import java.util.*;

public class Main {
    public static void ATMedian(int a[],int n){
        PriorityQueue<Integer> l=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> r=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(l.size()==0 || l.peek()>=a[i]) l.add(a[i]);
            else r.add(a[i]);
            if(l.size()-r.size()<0){
                l.add(r.peek());
                r.remove();
            }
            else if(l.size()-r.size()>1){
                r.add(l.peek());
                l.remove();
            }
            System.out.print(l.peek()+" ");
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int a[]=new int[n];
            String ar[]=br.readLine().split(" ");
            for(int i=0;i<n;i++) a[i]=Integer.parseInt(ar[i]);
            ATMedian(a,n);
            System.out.println();
        }
    }
}
