Given a sentence, reverse the entire sentence word-by-word.

Note: 
 Solve using stack or in-place swap. Do not simply scan, split and print in reverse order.  Input Format
The first line of input contains T - the number of test cases. It's followed by T lines, each containing a sentence S of space-separated words of lowercase English alphabet. All the words are separated by a single space.

Output Format
For each test case, print the reversed sentence, separated by a newline.

Constraints
1 <= T <= 1000
1 <= len(S) <= 1000

Example
Input
3
hello world
a b c d
data structures and algorithms

Output
world hello
d c b a
algorithms and structures data


import java.io.*;
import java.util.*;

public class Main {
    public static void restack(String str){
        Stack<String> st=new Stack<String>();
        StringBuilder x=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ') {
                st.push(x.toString());
                x.delete(0,x.length());
            }
            else x.append(str.charAt(i));
        }
        st.push(x.toString());
        while(!st.isEmpty()){
            String y=st.peek();
            System.out.print(y+" ");
            st.pop();  
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        s.nextLine();
        while(t-->0){
            String str=s.nextLine();
            restack(str);
        }
    }
}
