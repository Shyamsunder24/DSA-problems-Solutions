You are given 4 arrays of integers: A, B, C, and D. You have to find the number of quadruples (i, j, k, l) such that A[i]^B[j]^C[k]^D[l] = 0, where ^ is the bitwise XOR operator.

Input Format
The first line of input contains T - the number of test cases. It's followed by 5T lines, the first line contains N - the size of the array. The next 4 lines contain the elements of the arrays A, B, C, and D respectively.

Output Format
Print the total number of quadruples for each test case, separated by a new line.

Constraints
10 points
1 <= T <= 100
1 <= N <= 20
1 <= A[i] <= 100

20 points
1 <= T <= 100
1 <= N <= 100
1 <= A[i] <= 100

70 points
1 <= T <= 100
1 <= N <= 500
1 <= A[i] <= 100

Example
Input
3
4
31 8 28 10 
18 7 22 5 
16 25 20 14 
39 9 34 19 
2
27 21 
39 40 
64 77 
36 5 
8
49 73 58 30 72 44 78 23 
9 40 65 92 42 87 3 27 
29 40 12 3 69 9 57 60 
33 99 78 16 35 97 26 12 

Output
2
0
36

Explanation

Test-Case 1
There are only 2 quadruples with XOR=0: 28^22^25^19 and 28^5^16^9.

Test-Case 2
None of the quadruples has XOR=0.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine()); 
        StringBuilder result = new StringBuilder();
        while(t-->0) {
            int N =Integer.parseInt(br.readLine());  
            int[] A = new int[N];
            int[] B = new int[N];
            int[] C = new int[N];
            int[] D = new int[N];
            String []in1=br.readLine().split(" ");
            for (int i = 0; i < N; i++) A[i] =Integer.parseInt(in1[i]);
             String []in2=br.readLine().split(" ");
            for (int i = 0; i < N; i++) B[i] = Integer.parseInt(in2[i]);
             String []in3=br.readLine().split(" ");
            for (int i = 0; i < N; i++) C[i] = Integer.parseInt(in3[i]);
             String []in4=br.readLine().split(" ");
            for (int i = 0; i < N; i++) D[i] =Integer.parseInt(in4[i]);
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int xorAB = A[i] ^ B[j];
                    hm.put(xorAB, hm.getOrDefault(xorAB, 0) + 1);
                }
            }
            int count = 0;
            for (int k = 0; k < N; k++) {
                for (int l = 0; l < N; l++) {
                    int xorCD = C[k] ^ D[l];
                    int target = xorCD;
                    count += hm.getOrDefault(target, 0);
                }
            }
            result.append(count).append("\n");
        }
        System.out.print(result.toString());
    }
}
