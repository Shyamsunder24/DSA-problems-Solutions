Given a string S and an integer K, print the length of the longest substring which contains at most K vowels.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines, the first line contains K - the max number of vowels and the second line contains a string of size N.

Output Format
For each test case, print the length of the longest substring which contains at most K vowels, separated by newline.

Constraints
10 points
1 <= N <= 102

20 points
1 <= N <= 103

70 points
1 <= N <= 104

General Constraints
1 <= T <= 100
0 <= K <= N
'a' <= s[i] <= 'z'

Example
Input
3
2
smartinterviews
1
algorithms
2
searching

Output
8
6
7

Explanation

Test Case 1:
We have 2 substrings of length 8 which have at most 2 vowels: "smartint", "rtinterv"

Test Case 2:
We have a substring of length 6 which has at most 1 vowel: "rithms"

Test Case 3:
We have a substring of length 7 which has at most 2 vowels: "arching"

import java.io.*;
import java.util.*;

public class Main {
    static int maxSub(String org,int n){
        Set<Character> hs= Set.of('a','e','i','o','u');
        int max=0,start=0,count=0;
        for(int i=0;i<org.length();i++){
            if(hs.contains(org.charAt(i))) count++;
            while(count>n){
                if(hs.contains(org.charAt(start))) count--;
                start++;
            }
            max=Math.max(max,i-start+1);
        }
        return max;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String org=br.readLine();
            System.out.println(maxSub(org,n));
        }
    }
}
