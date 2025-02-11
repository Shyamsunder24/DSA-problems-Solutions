Given a binary tree with unique elements, check if it's a Binary Search Tree.
The input is given in the form of a complete binary tree, represented using an array. Assuming the array index starts from 1, the root will be at index 1. For every index i, its child nodes will be at 2i and 2i+1.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the number of nodes in the tree. The next line contains N integers - nodes of the binary tree in the form of a Complete Binary Tree.

Output Format
For each test case, print "True" if the given Binary Tree is a Binary Search Tree, "False" otherwise, separated by a newline.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 10000

Example
Input
5
11
92 10 963 5 334 928 973 2 9 263 860
9
156 153 6947 149 154 1761 7230 9 152
4
40 49 87 651
5
449 792 594 688 618
15
736 43 882 3 460 741 887 0 42 247 465 739 844 886 888

Output
False
True
False
False
True

import java.io.*;
import java.util.*;

public class Main {

    public static boolean isBST(int[] arr, int i, Integer[] prev) {
        if (i>= arr.length) return true;
        if (!isBST(arr, 2 * i, prev)) return false;
        if (prev[0] != null && arr[i] <= prev[0]) return false;
        prev[0] = arr[i];
        return isBST(arr, 2*i+1, prev);
    }

    public static boolean isBST(int[] arr) {
        Integer[] prev = {null};
        return isBST(arr, 1, prev);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0) {
            int N =Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            String str[]=br.readLine().split(" ");
            for (int i = 1; i <= N; i++) arr[i] =Integer.parseInt(str[i-1]);
            if (isBST(arr)) System.out.println("True"); 
            else System.out.println("False");
        }
    }
}
