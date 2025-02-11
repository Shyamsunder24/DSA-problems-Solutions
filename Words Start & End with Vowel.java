Given a list of words containing lowercase / uppercase English alphabets, you have to count the number of words between ith word and jth word that start and end with vowels.

Input Format
First line of input contains N - number of words. The next line contains N words, separated by space. The next line contains Q - number of queries. Each of the next Q lines contains two integers i and j, separated by space.

Output Format
For each query, print the count for given [i, j], separated by newline.

Constraints
30 points
1 <= N <= 104
1 <= Q <= 103

70 points
1 <= N <= 104
1 <= Q <= 105

General Constraints
0 <= i <= j < N
1 <= len(word) <= 10

Example
Input
10
smart Ursula eerie code abyss Arjuna Expasito data Ace hacker
3
1 3
5 8
3 4

Output
2
3
0

Explanation

Test Case 1:
The words that start and end with vowels between [1,3] ie [Ursula, eerie, code] are: "Ursula", "eerie"

Test Case 2:
The words that start and end with vowels between [5,8] are: "Arjuna", "Expasito", "Ace"

Test Case 3:
There are no words that start and end with vowels between [3,4].

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> hs= new HashSet<Character>();
        hs.add('a');
        hs.add('i');
        hs.add('e');
        hs.add('o');
        hs.add('u');

        int x=Integer.parseInt(br.readLine());
        String[] str=br.readLine().split(" ");
        int vo[]=new int[x];
        for(int i=0;i<x;i++){
            String ch=str[i];
            ch=ch.toLowerCase();
            if(hs.contains(ch.charAt(0)) && hs.contains(ch.charAt(ch.length()-1))) vo[i]=1;
        }
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            String[] in=br.readLine().split(" ");
            int n=Integer.parseInt(in[0]);
            int m=Integer.parseInt(in[1]);
            int count=0;
            for(int i=n;i<=m;i++){
                count=count+vo[i];
            }
            System.out.println(count);
        }
    }
}
