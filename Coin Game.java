import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int a=s.nextInt();
            int b=s.nextInt();
            if((a+b)%3==0 && 2*Math.min(a,b)>=Math.max(a,b)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
