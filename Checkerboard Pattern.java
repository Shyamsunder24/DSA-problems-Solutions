import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1; k<=t; k++) {
            int N=sc.nextInt();
            System.out.println("Case #"+k+":");
            for(int i=0; i<2*N; i++) {
                for(int j=0; j<2*N; j++) {
                    if(i%2==0) {
                        if((i+j)%2==0) {
                            System.out.print("**");
                        } 
                        else {
                            System.out.print("--");
                        }
                    }
                    else {
                        if(j%2==0) {
                            System.out.print("**");
                        }
                        else {
                            System.out.print("--");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
