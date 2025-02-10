Given an array, you have to find the frequency of a number X.

Input Format
The first line of input contains N - size of the array. The next line contains N integers, the elements of the array. The next line contains Q - number of queries. Each of the next Q lines contains a single integer X, for which you have to find the frequency of X in the given array.

Output Format
For each query, print the frequency of X, separated by a new line.

Constraints
20 points
1 <= N <= 105
1 <= Q <= 102
-108 <= ar[i] <= 108

30 points
1 <= N <= 105
1 <= Q <= 105
-108 <= ar[i] <= 108

50 points
1 <= N <= 105
1 <= Q <= 105
-108 <= ar[i] <= 108

Example
Input
9
-6 10 -1 20 -1 15 5 -1 15
5
-1
10
8
15
20

Output
3
1
0
2
1

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int x = s.nextInt();
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int t=s.nextInt();
        while(t-->0){
            int y=s.nextInt();
            if(hm.get(y)==null)System.out.println(0);
            else System.out.println(hm.get(y));
        }
    }
}
