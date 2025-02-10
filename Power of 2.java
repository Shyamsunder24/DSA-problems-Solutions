import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
    Scanner s=new Scanner(System.in);
    int t=s.nextInt();
    while(t-->0){
        long n=s.nextLong();
        int count=0;
        for(int i=0;i<64;i++){
            if((n&1)==1) count++;
            n=n>>1;
        }
        if (count==1) System.out.println("True");
        else System.out.println("False");
    }
    }
}
