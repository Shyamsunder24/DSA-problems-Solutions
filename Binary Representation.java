import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            long n=s.nextLong();
            String str="";
            if(n==0) System.out.println(0);
            else{
            while(n!=0){
                if((n&1)==1) str="1"+str;
                else str="0"+str;
                n=n>>1;
            }
            System.out.println(str);
        }}
    }
}
