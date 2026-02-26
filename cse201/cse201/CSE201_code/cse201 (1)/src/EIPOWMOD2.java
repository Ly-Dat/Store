import java.util.*;
import java.io.*;


public class EIPOWMOD2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long res = calMod(a, b, c);
        System.out.println(res);
    }

    private static long calMod(long a, long b, long c) {

        long res = 1;
        for (; b > 0;) {
            if (b % 2 != 0)
                res = (res * a) % c;
            b /= 2;
            a = (a * a) % c;
        }
        return res;
    }

}
