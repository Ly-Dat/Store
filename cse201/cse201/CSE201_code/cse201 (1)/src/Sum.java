import java.util.*;

public class Sum {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nTestcases = sc.nextInt();

        for (int i = 0; i < nTestcases; i++) {
            var a = sc.nextInt();
            var b = sc.nextInt();
            var c = sc.nextInt();

            if (a == b && a == c) {
                if (a == 0)
                    sb.append("YES");
                else
                    sb.append("NO");
            } else if (a + b == c || a + c == b || b + c == a)
                sb.append("Yes");
            else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
