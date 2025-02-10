import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n1=s.nextInt();
            int m1=s.nextInt();
            int a[][]=new int[n1][m1];
            for(int i=0;i<n1;i++){
                for(int j=0;j<m1;j++){
                    a[i][j]=s.nextInt();
                }
            }
            int n2=s.nextInt();
            int m2=s.nextInt();
            int b[][]=new int[n2][m2];
            for(int i=0;i<n2;i++){
                for(int j=0;j<m2;j++){
                    b[i][j]=s.nextInt();
                }
            }
            int c[][]=new int[n1][m2];
            for(int i=0;i<n1;i++){
                for(int j=0;j<m2;j++){
                    c[i][j]=0;
                    for(int k=0;k<n2;k++){
                        c[i][j]+=a[i][k]*b[k][j];
                    }
                    System.out.print(c[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
