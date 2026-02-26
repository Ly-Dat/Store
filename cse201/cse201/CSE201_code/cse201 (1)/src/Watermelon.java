import java.util.*;

public class Watermelon {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var n = sc.nextInt();
        boolean flag = false;
        int temp = n /2;
        if (n % 2 == 0){
            if (temp %2 == 0){
                flag = true;
            }else {
                n -= 2;
                while(!flag && n > 1){
                    if (n % 2 == 0){
                        flag = true;
                    }
                    n -= 2;
                }
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }
}
