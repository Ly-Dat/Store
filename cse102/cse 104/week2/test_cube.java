
import java.util.Scanner;

public class test_cube {

    static void find_layer(long[] bricks, int[] points) {
        long[] KQ = new long[bricks.length];
        long sum = 0;
        int i = 0;
        int layer = 0;
        while (sum < bricks[bricks.length - 1]) {
            layer++;
            sum += layer + (layer * (layer - 1) / 2);

            if (sum >= bricks[i]) {
                if (sum > bricks[i]) {
                    sum -= layer + (layer * (layer - 1) / 2);
                    layer--;
                }
                KQ[points[i]] = layer;
                i++;
                if (i == bricks.length) {
                    break;
                }
            }
        }
        for (int m = 0; m < bricks.length; m++) {
            System.out.print(KQ[m] + " ");
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        long[] bricks = new long[k];
        int[] position = new int[k];
        for (int i = 0; i < k; i++) {
            bricks[i] = sc.nextLong();
            position[i] = i;
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                if (bricks[i] > bricks[j]) {
                    long t = bricks[i];
                    bricks[i] = bricks[j];
                    bricks[j] = t;
                    int t1 = position[i];
                    position[i] = position[j];
                    position[j] = t1;
                }
            }
        }
        find_layer(bricks, position);
    }
}
