Given a string of characters, find the first repeating character.

Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each line contains a single string of characters.

Output Format
For each test case, print the first repeating character, separated by a new line. If there are none, print '.'.

Constraints
1 <= T <= 1000
'a' <= str[i] <= 'z'
1 <= len(str) <= 104

Example
Input
4
datastructures
algorithms
smartinterviews
hackerrank

Output
a
.
t
r

import java.io.*;
import java.util.*;

public class Main {

    static void rep(String str){
        HashSet<Character>hs=new HashSet<>();
        char ans='.';
        for(int i=0;i<str.length();i++){
            if(hs.contains(str.charAt(i))){
                ans=str.charAt(i);
                break;
            }
            else hs.add(str.charAt(i));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            String str=s.next();
            rep(str);
        }
    }
}
