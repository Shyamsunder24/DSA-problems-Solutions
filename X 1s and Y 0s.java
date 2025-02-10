import java.io.*;
import java.util.*;

public class Main {
    static int mod=(int)(1e9+7);
    private static long powerMod(long b, long e) {
        long result=1;
        b=b%mod;
        while(e>0){
            if((e&1)==1) result=((result%mod)*(b%mod))%mod;
            b=((b%mod)*(b%mod))%mod;
            e>>=1;
        }
        return result;
    }

    public static void main(String[] args) {
        int mod=(int)(1e9+7);
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int i=s.nextInt();
            int j=s.nextInt();
            long ans=((powerMod(2,i+j)%mod)-(powerMod(2,j)%mod)+mod)%mod;
            System.out.println(ans);
        }
    }
}
