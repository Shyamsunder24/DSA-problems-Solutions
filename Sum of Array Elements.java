import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            long sum=0;
            int n=s.nextInt();
            long a[]=new long[n];
            for(int i=0;i<n;i++){
                a[i]=s.nextLong();
            }
            for(int j=0;j<n;j++){
                sum+=a[j];
            }
            System.out.println(sum);
        }
    }
}
