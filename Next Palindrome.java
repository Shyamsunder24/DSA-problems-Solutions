#70 points
import java.io.*;
import java.util.*;

public class Main {
     private static String mirror(String half, boolean evenLength) {
        StringBuilder sb = new StringBuilder(half);
        if (!evenLength) {
            sb.setLength(sb.length() - 1);
        }
        return half + sb.reverse().toString();
    }
    
    private static String increment(String half) {
        StringBuilder sb = new StringBuilder(half);
        int len = sb.length();
        for (int i = len - 1; i >= 0; i--) {
            if (sb.charAt(i) != '9') {
                sb.setCharAt(i, (char)(sb.charAt(i) + 1));
                break;
            } else {
                sb.setCharAt(i, '0');
            }
        }
        if (sb.charAt(0) == '0') {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

    public static String palindrome(String num){
       int len = num.length();
        String firstHalf = num.substring(0, (len + 1) / 2);
        String palindrome = mirror(firstHalf, len % 2 == 0);
        
        if (palindrome.compareTo(num) > 0) {
            return palindrome;
        }
        
        firstHalf = increment(firstHalf);
        return mirror(firstHalf, len % 2 == 0);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            System.out.println(palindrome(br.readLine()));
        }
    }
}
