You are given an array of N elements. All elements of the array are in range 1 to N-2. All elements occur once except two numbers, which occur twice. Your task is to find the two repeating numbers.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains N - the size of the array and second line contains the elements of the array.

Output Format
Print the 2 repeated numbers in sorted manner, for each test case, separated by new line.

Constraints
30 points
1 <= T <= 100
4 <= N <= 103

70 points
1 <= T <= 100
4 <= N <= 106

Example
Input
2
8
1 3 2 3 4 6 5 5
10
1 5 2 8 1 4 7 4 3 6

Output
3 5
1 4
import java.io.*;
import java.util.*;

public class Main {
    static void solve(int a[],int n){
        HashSet<Integer> hs=new HashSet<Integer>();
        int []x=new int[2];
        int j=0;
        for(int i=0;i<n;i++){
            if(hs.contains(a[i])) x[j++]=a[i];
            else hs.add(a[i]);
        }
        Arrays.sort(x);
        System.out.println(x[0]+" "+x[1]);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t =s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=s.nextInt();
            }
            solve(a,n);
        }
    }
}
