Given a string S consisting of only lowercase characters, find the length of the longest substring that does not contain any vowel.

Input Format
First line of input contains T - number of test cases. Its followed by T lines, each line contains a string of size N, containing only lowercase english alphabets.

Output Format
For each test case, print the length of the largest substring that does not contain any vowel, separated by newline.

Constraints
1 <= T <= 100
1 <= N <= 104

Example
Input
3
smartinterviews
algorithms
searching

Output
2
4
3

Explanation

Test Case 1:
We have multiple substrings of length 2 which doesn't contain any vowels: "sm", "rt", "nt", "rv", "ws"

Test Case 2:
We have a substring of length 4 which doesn't contain any vowels: "thms"

Test Case 3:
We have a substring of length 3 which doesn't contain any vowels: "rch"

import java.io.*;
import java.util.*;

public class Main {
    static int maxSub(String org){
        Set<Character> hs= Set.of('a','e','i','o','u');
        int max=0,count=0;
        for(int i=0;i<org.length();i++){
            if(!hs.contains(org.charAt(i))) count++;
            else {
                max=Math.max(max,count);
                count=0;
            }
        }
        max=Math.max(max,count);
        return max;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String org=br.readLine();
            System.out.println(maxSub(org));
        }
    }
}
