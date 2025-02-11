Implement the Stack data structure and perform push / pop operations.

Note: 
 Do not use any inbuilt functions / libraries for the Stack.  Input Format
The first line of input contains T - number of operations. It is followed by T lines, each line contains either "push x" or "pop".

Output Format
For each "pop" operation, print the popped element, separated by a newline. If the stack is empty, print "Empty".

Constraints
1 <= T <= 10000
-100 <= x <= 100

Example
Input
8
push 5
pop
pop
push 10
push -15
pop
push -10
pop

Output
5
Empty
-15
-10

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int a[]=new int[10000];
        int top=-1;
        while(t-->0){
            String str=s.next();
            if(str.equals("push")){
                int n=s.nextInt();
                if(top<10000) a[++top]=n;
            }
            else if(top==-1) System.out.println("Empty"); 
            else{
                System.out.println(a[top]);
                top--;
            }
        }
    }
}
