Given an array of integers, find the largest number that can be constructed by concatenating all the elements of the given array.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the size of the array and the second line contains N integers - the elements of the array.

Output Format
For each test case, print the largest number that can be constructed by concatenating all the elements of the given array, separated by a new line.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 1000

Example
Input
3
8
49 73 58 30 72 44 78 23
4
69 9 57 60
2
40 4

Output
7873725849443023
9696057
440

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out=new StringBuilder();
        int t=Integer.parseInt(br.readLine().trim());
        while(t-->0){
            int n=Integer.parseInt(br.readLine().trim());
            String ar[]= br.readLine().trim().split(" ");
            Arrays.sort(ar,(a,b) ->(b+a).compareTo(a+b));
            if(ar[0].equals("0")) out.append("0\n");
            else{
                for(String num :ar){
                    out.append(num);
                }
                out.append("\n");
            }
        }
            System.out.println(out);
    }
}
