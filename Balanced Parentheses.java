Write a program to generate all possible strings with balanced parentheses having N pairs of curly braces.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each containing a single integer N.

Output Format
For each test case, print each combinational pair of balanced parenthesis of length N in a lexicographical order along with the test case number, separated by a new line.

Constraints
1 <= T <= 12
1 <= N <= 12

Example
Input
2
3
2

OutputTest Case #1:
{{{}}}
{{}{}}
{{}}{}
{}{{}}
{}{}{}
Test Case #2:
{{}}
{}{}

import java.io.*;
import java.util.*;

public class Main {
    static void solve(char c[],int n,int idx,int open,int close){
        if(idx==n){
            System.out.print(c);
            System.out.println();
            return;
        }
        if(open<n/2){
            c[idx]='{';
            solve(c,n,idx+1,open+1,close);
        }
        if(close<open){
            c[idx]='}';
            solve(c,n,idx+1,open,close+1);
        }
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=1;i<=t;i++){
            int x=s.nextInt();
            int n=2*x;
            char c[]=new char[n];
            System.out.println("Test Case #"+i+":");
            solve(c,n,0,0,0);
        }
    }
}
