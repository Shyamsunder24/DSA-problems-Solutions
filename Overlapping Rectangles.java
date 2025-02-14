Overlapping Rectangles
rectangles parallel to coordinate axes, find the area covered by them.

Input Format
The first line of input contains T - the number of test cases. It is followed by 2T lines. The first line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the bottom-left and top-right coordinates of rectangle-1. The second line of each test case contains 4 integers - xbl, ybl, xtr, ytr - the bottom-left and top-right coordinates of rectangle-2.

Output Format
For each test case, print the area covered by the 2 rectangles, separated by a newline.

Constraints
1 <= T <= 10000
-106 < x,y <= 106
(xbl, ybl) < (xtr, ytr)

Example
Input
4
2 5 4 6
1 2 5 4
-4 -3 -2 5
-3 -5 1 3
1 0 3 5
2 3 5 8
-2 2 4 4
-3 1 5 5

Output
10
42
23
32

import java.io.*;
import java.util.*;

public class Main {
    static void solve(int xbl1,int ybl1,int xtr1,int ytr1,int xbl2,int ybl2,int xtr2,int ytr2){
        // int a1=Math.abs(xtr1-xbl1)*Math.abs(ytr1-ybl1);
        // int a2=Math.abs(xtr2-xbl2)*Math.abs(ytr2-ybl2);
        long a1=(long)(xtr1-xbl1)*(ytr1-ybl1);
        long a2=(long)(xtr2-xbl2)*(ytr2-ybl2);

        long ow=Math.max(0,Math.min(xtr1,xtr2)-Math.max(xbl1,xbl2));
        long oh=Math.max(0,Math.min(ytr1,ytr2)-Math.max(ybl1,ybl2));
        long ola=ow*oh;
        long total=a1+a2-ola;
        System.out.println(total);
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int xbl1=s.nextInt();
            int ybl1=s.nextInt();
            int xtr1=s.nextInt();
            int ytr1=s.nextInt();
            int xbl2=s.nextInt();
            int ybl2=s.nextInt();
            int xtr2=s.nextInt();
            int ytr2=s.nextInt();
            solve(xbl1,ybl1,xtr1,ytr1,xbl2,ybl2,xtr2,ytr2);
        }
    }
}
