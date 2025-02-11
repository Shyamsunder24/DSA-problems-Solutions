Given 2 strings, check if they are anagrams. An anagram is a rearrangement of the letters of one word to form another word. In other words, some permutations of string A must be the same as string B.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each line containing 2 space-separated strings.

Output Format
For each test case, print True/False, separated by a new line.

Constraints
10 points
1 <= T <= 100
1 <= len(S) <= 103
'a' <= S[i] <= 'z'

40 points
1 <= T <= 100
1 <= len(S) <= 105
'a' <= S[i] <= 'z'

Example
Input
4
iamlordvoldemort tommarvoloriddle
b h
stop post
hi hey

Output
True
False
True
False

import java.io.*;
import java.util.*;

public class Main {

    static boolean anagram(String s1,String s2){
        int c1[]=new int[26];
        int c2[]=new int[26];
        for(int i=0;i<s1.length();i++){
            c1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            c2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(c1[i]!=c2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            String s1=s.next();
            String s2=s.next();
            if(anagram(s1,s2)) System.out.println("True");
            else System.out.println("False");
        }
    }
}
