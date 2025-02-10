import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            long a=s.nextLong();
            long b=s.nextLong();
            long temp1=a;
            long temp2=b;
            long temp=0;
            while(temp2!=0){
                temp=temp2;
                temp2=temp1%temp2;
                temp1=temp;
            }
            long hcf=temp1;
            long lcm=(a*b)/hcf;
            System.out.println(lcm+" "+hcf);
        }
    }
}
