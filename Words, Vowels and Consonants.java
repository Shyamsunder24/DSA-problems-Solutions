Given a sentence containing only uppercase/lowercase english alphabets and spaces, you have to count the number of words, vowels and consonants.

Input Format
The first line of input contains T - number of test cases. It's followed by T lines, each line contains a single sentence.

Output Format
For each test case, print the number of words, vowels and consonants, separated by newline.

Constraints
1 <= T <= 1000
1 <= len(sentence) <= 104

Example
Input
4
Hi
Hello World
  Exception  
Hi there

Output
1 1 1
2 3 7
1 4 5
2 3 4

import java.io.*;
import java.util.*;

public class Main {
    static void findwvc(String str,int n){
        HashSet<Character> hs=new HashSet<Character>();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        int w=0;
        if(str.isEmpty()) w=0;
        else{ 
            String sr[]=str.trim().split("\\s+");
            w=sr.length;
        }
        int v=0,c=0;
        for(char ch :str.toLowerCase().toCharArray()){
            if(hs.contains(ch)) v++;
            else if(ch!=' ') c++;
        }
        System.out.println(w+" "+v+" "+c);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String str=br.readLine().trim();
            findwvc(str,str.length());
        }
    }
}
