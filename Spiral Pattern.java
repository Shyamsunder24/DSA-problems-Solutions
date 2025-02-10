import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        int x=1;
        while(x <= t){
            int n =s.nextInt();
            System.out.println("Case #"+x+":");
            x++;
            char mat[][]=new char[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(mat[i],' ');
            }
            //
            if(n==2){
                System.out.println("* *");
                System.out.println("* *");
            }
            else{
            int top=0,bottom=n-1,left=0,right=n-1;
            int dir=0;
            while( left<=right && top<=bottom ){
                //top
                if(dir==0){
                    for(int i=left-1;i<=right;i++) {
                        if(i>=0) mat[top][i]='*';
                    }
                    top++;
                }
                //right
                else if(dir==1){
                    for(int i=top-1;i<=bottom;i++) mat[i][right]='*';
                    right-=2;
                }
                //bottom
                else if(dir==2){
                    for(int i=right+1;i>=left;i--) mat[bottom][i]='*';
                    bottom-=2;
                }
                //left
                else {
                    for(int i=bottom+1;i>top;i--) mat[i][left]='*';
                    left+=2;
                    top++;
                }
                dir=(dir+1)%4;
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
            }
        }
    }
}
