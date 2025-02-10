import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        StringBuilder output=new StringBuilder();
        for(int i=0;i<t;i++)
        {
            String point1[]=br.readLine().split(" ");
            String point2[]=br.readLine().split(" ");
            String point3[]=br.readLine().split(" ");
            long x1=Integer.parseInt(point1[0]);
            long y1=Integer.parseInt(point1[1]);
            long x2=Integer.parseInt(point2[0]);
            long y2=Integer.parseInt(point2[1]);
            long x3=Integer.parseInt(point3[0]);
            long y3=Integer.parseInt(point3[1]);
            long result=(x1*(y2-y3))+(x2*(y3-y1))+(x3*(y1-y2));
            if(result==0)
            {
                System.out.println("Yes");

            }
            else
            {
               System.out.println("No");
            }
        
        }
        
    }
}
