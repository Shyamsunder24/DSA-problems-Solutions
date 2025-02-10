import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t= scanner.nextInt();
        long[] results = new long[t];
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            results[i] = countTrailingZeros(n);
        }
        for (long result : results) {
            System.out.println(result);
        }
    }

    private static long countTrailingZeros(long n) {
        long ans = 0;
        long power = 5;
        while (n>= power) {
            ans +=n / power;
            power*= 5;
        }
        return ans;
    }
}
