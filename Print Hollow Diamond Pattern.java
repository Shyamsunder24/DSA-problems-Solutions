import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int cou=1;
        while(t-->0){
            int n=s.nextInt();
            int mid=n/2;
            System.out.println("Case #"+cou+":");
            cou++;
            for(int i=0;i<=mid;i++){
                for(int j=i;j<mid;j++){
                    System.out.print(" ");
                }
                if(i==0) System.out.print("*");
                else{
                    System.out.print("*");
                    for(int j=0;j<2*i-1;j++){
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
                System.out.println();
            }
            for(int i=mid+1;i<n;i++){
                for(int j=0;j<i-mid;j++){
                    System.out.print(" ");
                }
                if(i==n-1) System.out.print("*");
                else{
                    System.out.print("*");
                    for(int j=0;j<(n-i-1)*2-1;j++){
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
