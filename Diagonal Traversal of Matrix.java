import java.io.*;
import java.util.*;

public class Main {
    static void solve(int a[][],int n){
        int dsum[]=new int[2*n-1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dsum[i-j+n-1]+=a[i][j];
            }
        }
        for(int i=0;i<2*n-1;i++){
            System.out.print(dsum[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n=s.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=s.nextInt();
                }
            }
            solve(a,n);
        }
    }
}
