There is a line of houses, where each house can be painted with one of the three colors: red, blue and green. The cost of painting each house with a certain color is different. Find the minimum cost to paint all the houses such that no two adjacent house have the same color.

Input Format
The first line of input contains T - number of test cases. It's followed by 4T lines, the first line contains N - number of houses and the second, third and fourth line contains the costs of each house for red, green and blue respectively.

Output Format
For each test case, print the minimum cost, separated by new line.

Constraints
1 <= T <= 100
1 <= N <= 103
1 <= R[i], G[i], B[i] <= 103

Example
Input
1
6
7 3 8 6 1 2
5 6 7 2 4 3
10 1 4 9 7 6

Output
18

Explanation

7 3 8 6 1 2 
5 6 7 2 4 3 
10 1 4 9 7 6

Min cost: 
H-> House
H1 with Green, H2 with Red, H3 with Blue, H4 with Green, H5 with Red, H6 with Green
Overall cost: 5+3+4+2+1+3 = 18

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int r[]=new int[n+1];
            int g[]=new int[n+1];
            int b[]=new int[n+1];
            for(int i=0;i<n;i++) r[i]=s.nextInt();
            for(int i=0;i<n;i++) g[i]=s.nextInt();
            for(int i=0;i<n;i++) b[i]=s.nextInt();
            int cr,cg,cb;
            int pb=0,pg=0,pr=0;
            for(int i=0;i<n;i++){
                cr=Math.min(pb,pg)+r[i];
                cg=Math.min(pb,pr)+g[i];
                cb=Math.min(pr,pg)+b[i];
                pr=cr;
                pb=cb;
                pg=cg;
            }
            int min=Integer.MAX_VALUE;
            min=Math.min(min,pb);
            min=Math.min(min,pg);
            min=Math.min(min,pr);
            System.out.println(min);
        } 
    }
}
