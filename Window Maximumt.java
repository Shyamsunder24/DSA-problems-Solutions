Given an array of integers of size N and a window size K. For each continuous window of size K, find the highest element in the window. Output the sum of the highest element of all the windows.

Input Format
The first line of input contains T - number of test cases. It is followed by 2T lines, the first line contains N and K - the size of the array and the window size K. The second line contains N integers - the elements of the array.

Output Format
For each test case, print the sum of the highest element of all the windows of size K, separated by a newline.

Constraints
30 points
1 <= T <= 1000
1 <= N <= 1000
1 <= K <= N
-104 <= A[i] <= 104

70 points
1 <= T <= 1000
1 <= N <= 10000
1 <= K <= N
-104 <= A[i] <= 104

Example
Input
2
7 3
4 10 54 11 8 7 9
4 2
11 15 12 9

Output
182
42

Explanation

Example 1:
Window [4 10 54] : maximum element = 54
Window [10 54 11] : maximum element = 54
Window [54 11 8] : maximum element = 54
Window [11 8 7] : maximum element = 11
Window [8 7 9] : maximum element = 9
Total Sum = 54 + 54 + 54 + 11 + 9 = 182

Example 2:
Window [11 15] : maximum element = 15
Window [15 12] : maximum element = 15
Window [12 9] : maximum element = 12
Total Sum = 15 + 15 + 12 = 42

import java.io.*;
import java.util.*;

public class Main {
    static long dequ(int a[],int n,int k){
        long sum=0;
        Deque<Integer> d=new ArrayDeque<Integer>();
        for(int i=0;i<k;i++){
            while(!d.isEmpty() && d.getLast()<a[i]){
                d.removeLast();
            }
            d.addLast(a[i]);
        }
        sum+=d.getFirst();
        for(int i=k;i<n;i++){
            if(d.getFirst()==a[i-k]) d.removeFirst();
            while(!d.isEmpty() && d.getLast()<a[i]) d.removeLast();
            d.addLast(a[i]);
            sum+=d.getFirst();
        }
        return sum;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            int a[]=new int[n];
            String in[]=br.readLine().split(" ");
            for(int i=0;i<n;i++) a[i]=Integer.parseInt(in[i]);
            System.out.println(dequ(a,n,k));
        }
    }
}
