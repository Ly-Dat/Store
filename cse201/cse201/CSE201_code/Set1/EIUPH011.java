import java.util.*;

public class EIUPH011 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        NewArray(sb, n);
        System.out.println(sb);
    }

    public static StringBuilder NewArray(StringBuilder sb, int n) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (!numbers.contains(number)) {
                sb.append(number).append(" ");
                numbers.add(number);
            }
        }
        return sb;
    }

}
