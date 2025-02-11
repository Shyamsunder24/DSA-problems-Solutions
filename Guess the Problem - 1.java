Understand the problem statement from the given sample input and output.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each line contains 2 strings A and B, separated by space, consisting only of lowercase English alphabets.

Output Format
For each test case, print the desired output, separated by a new line.

Constraints
10 points
1 <= T <= 100
1 <= len(A), len(B) <= 100

40 points
1 <= T <= 1000
1 <= len(A) <= 5000
1 <= len(A), len(B) <= 5000

Example
Input
2
data structures
smart interviews

Output
srucures
ineview

import java.io.*;
import java.util.*;

public class Main {

    static void remove(String str1,String str2){
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<str2.length();i++){
            hs.add(str2.charAt(i));
        }
        for(int i=0;i<str1.length();i++){
            hs.remove(str1.charAt(i));
        }
        for(int i=0;i<str2.length();i++){
            if(hs.contains(str2.charAt(i))){
                System.out.print(str2.charAt(i));
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            String str1=s.next();
            String str2=s.next();
            remove(str1,str2);
        }
    }
}
