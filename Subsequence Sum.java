Given a sequence of N numbers: S1, ..., SN, determine how many subsequences of S have a sum between A and B inclusive.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines, the first line contains - N, A, and B separated by space. The next line contains the sequence of N numbers.

Output Format
For each test case, print the result, separated by a new line.

Constraints
30 points
1 <= T <= 100
1 <= N <= 15

120 points
1 <= T <= 100
1 <= N <= 30

General Constraints
-107 <= A <= B <= 107
-107 <= S[i] <= 107

Example
Input
2
3 -1 2
1 -2 3
5 5 15
1 4 -3 6 4

Output
5
20


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        while(t-->0) {
            String in[]=br.readLine().split(" ");
            int N =Integer.parseInt(in[0]);
            int A = Integer.parseInt(in[1]);
            int B = Integer.parseInt(in[2]);
            String str[]=br.readLine().split(" ");
            int[] S = new int[N];
            for (int i = 0; i < N; i++) S[i] = Integer.parseInt(str[i]);
            int mid = N / 2;
            int[] left = new int[mid];
            int[] right = new int[N - mid];
            System.arraycopy(S, 0, left, 0, mid);
            System.arraycopy(S, mid, right, 0, N - mid);
            List<Integer> leftSums = generateSubsequenceSums(left);
            List<Integer> rightSums = generateSubsequenceSums(right);
            Collections.sort(leftSums);
            long count = 0;
            for (int sum2 : rightSums) {
                int lowerBound = A - sum2;
                int upperBound = B - sum2;

                int leftLowerIndex = lowerBound(leftSums, lowerBound);
                int leftUpperIndex = upperBound(leftSums, upperBound);

                count += (leftUpperIndex - leftLowerIndex);
            }
            result.append(count).append("\n");
        }
        System.out.print(result.toString());   
    }

    private static List<Integer> generateSubsequenceSums(int[] a) {
        int n = a.length;
        List<Integer> sums = new ArrayList<>();
        int totalSubsequences = 1 << n;  
        for (int i = 0; i < totalSubsequences; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) sum += a[j];
            }
            sums.add(sum);
        }
        return sums;
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else  right = mid;
        }
        return left;
    }


    private static int upperBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }    
}
