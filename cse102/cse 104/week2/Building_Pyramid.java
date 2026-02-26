
import java.util.Scanner;

public class Building_Pyramid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_bricks = sc.nextInt();
        int layer = 0;
        while (num_bricks > 0) {
            layer++;
            num_bricks -= layer + (layer * (layer - 1) / 2);
            if (num_bricks < 0) {
                layer--;
                break;
            }
        }
        System.out.println(layer);
    }
}
