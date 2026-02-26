import java.util.*;
import java.io.*;

class EIPOWMOD2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long res = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                res = (res * a) % c;
            }
            b >>= 1;
            a = (a * a) % c;
        }
        /// 3 5 7
        /// res = 1*3 % 7 =3
        /// b = 2;
        /// a = 2;
        /// b=1// a =4
        System.out.println(res);
    }

}
