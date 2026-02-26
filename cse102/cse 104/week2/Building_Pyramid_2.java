
import java.util.Scanner;

public class Building_Pyramid_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long bricks = sc.nextLong();
            long layer = (long) Math.cbrt(bricks * 6);
            long total = (layer * (layer + 1) * (layer + 2)) / 6;
            if (total > bricks) {
                layer--;
            }
            sb.append(layer + " ");
        }
        System.out.println(sb);
    }
}
