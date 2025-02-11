You are given an array of 0's and 1's. Find the length of the longest subarray which has an equal number of 0's and 1's.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines, the first line contains N - the size of the array. The second line contains the elements of the array.

Output Format
For each test case, print the length of the longest subarray which has equal 0's and 1's, separated by a newline.

Constraints
10 points
1 <= T <= 100
1 <= N <= 100

20 points
1 <= T <= 100
1 <= N <= 1000

70 points
1 <= T <= 1000
1 <= N <= 104

Example
Input
2
5
0 1 1 0 1
6
1 1 1 1 1 0

Output
4
2

Explanation

Example 1: The longest subarray which has an equal number of 0's and 1's is [0 1 1 0]

Example 2: The longest subarray which has an equal number of 0's and 1's is [1 0]

import java.io.*;
import java.util.*;

public class Main {

    static int equal01(int arr[],int n){
         int maxLength = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1); 
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i <n; i++) {
            if (arr[i] == 0) count0++; 
            else count1++;
            int diff = count0 - count1;
            if (hm.containsKey(diff)) maxLength = Math.max(maxLength, i - hm.get(diff)); 
            else hm.put(diff, i);
        }
        return maxLength;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String in[]=br.readLine().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=Integer.parseInt(in[i]);
            System.out.println(equal01(a,n));
        }
    }
}
