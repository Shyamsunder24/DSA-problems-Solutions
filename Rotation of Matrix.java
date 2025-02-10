import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int count=1;
        while(t-->0){
            int n=s.nextInt();
            int a[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=s.nextInt();
                }
            }
            System.out.println("Test Case #"+count+":");
            for(int i=0;i<n;i++){
                for(int j=n-1;j>=0;j--){
                    System.out.print(a[j][i]+ " ");
                }
                System.out.println();
            }
            count++;
        }
    }
}
