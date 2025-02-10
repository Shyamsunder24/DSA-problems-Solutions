import java.io.*;
import java.util.*;

public class Main {
    public static void find(int mat[][],int n){
        int top=0,bottom=n-1,left=0,right=n-1;
        while(top<=bottom && left<=right){
            //top
            for(int i=left;i<=right;i++) System.out.print(mat[top][i]+" ");
            top++;
            //right
            for(int i=top;i<=bottom;i++) System.out.print(mat[i][right]+" ");
            right--;
            //bottom
            if(top<=bottom){
                for(int i=right;i>=left;i--) System.out.print(mat[bottom][i]+" ");
                bottom--;
            }
            //left
            if(left<=right){
                for(int i=bottom;i>=top;i--) System.out.print(mat[i][left]+" ");
                left++;
            }    
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t-->0){
            int n =s.nextInt();
            int mat[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    mat[i][j]=s.nextInt();
                }
            }
            find(mat,n);
        }
    }
}
