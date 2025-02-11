Given an array, rotate it by K times in a clockwise direction.

Note: 
 Try to solve it by doing an in-place rotation and then print the rotated array.  Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines, the first line contains N - the size of the array and K - the degree of rotation. The second line contains the elements of the array.

Output Format
For each test case, print the k-rotated array, separated by a new line.

Constraints
10 points
1 <= T <= 100
1 <= N <= 103
1 <= K <= 103
1 <= ar[i] <= 100

40 points
1 <= T <= 100
1 <= N <= 104
1 <= K <= 109
1 <= ar[i] <= 100

Example
Input
1
7 3
3 10 4 5 10 7 2 

Output
10 7 2 3 10 4 5

import java.io.*;
import java.util.*;

public class Main {

    static void rotatearr(int a[],int n,int kr){
        kr=kr%n;
        for(int j=0;j<n;j++) {
            if(j<kr) System.out.print(a[n+j-kr]+" ");
            else System.out.print(a[j-kr]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int k=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            rotatearr(a,n,k);
        }
    }
}
