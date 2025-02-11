Understand the problem statement from the given sample input and output.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each line contains a string consisting only of lowercase English alphabets and an integer K.

Output Format
For each test case, print the desired output, separated by a new line.

Constraints
1 <= T <= 1000
1 <= len(str) <= 1000
0 <= k <= 100000

Example
Input
2
smart 3
interviews 10

Output
vpduw
sxdobfsogc


import java.io.*;
import java.util.*;

public class Main {

    static void addchar(String str,int n){
        String s1="";
        for(int i=0;i<str.length();i++){
            int x=str.charAt(i)+n;
            if(x<=122) s1+=(char)x;
            else{
                x=x-26;
                s1+=(char)x;
            }
        }
        System.out.println(s1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            String str=s.next();
            int n=s.nextInt();
            n=n%26;
            addchar(str,n);
        }
    }
}
