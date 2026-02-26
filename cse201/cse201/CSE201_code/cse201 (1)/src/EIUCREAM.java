import java.util.*;
import java.io.*;

public class EIUCREAM {
    static Scanner sc = new Scanner(System.in);
    static long temp = 0;
    static long temp2 = 0;

    

    public static void main(String[] args) {
        long n = sc.nextLong();
        long m = sc.nextLong();

        long res = calculateTheResult(n, m);

        System.out.println(res);
    }

    private static long calculateTheResult(long n, long m) {
        if (n < m)
            return n;
        temp = n / m;
        temp2 = n % m;
        return n - temp2 + calculateTheResult(temp + temp2, m);
    }

}
