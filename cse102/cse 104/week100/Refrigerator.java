
import java.util.Scanner;

public class Refrigerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int minSur_Area = Integer.MAX_VALUE;
        int best_A = 0, best_B = 0, best_C = 0;
        for (int a = 1; a * a * a <= L; a++) {
            if (L % a != 0) {
                continue;
            }
            for (int b = a; a * b * b <= L; b++) {
                if ((L / a) % b != 0) {
                    continue;
                }
                int c = L / (a * b);

                if (b <= c) {
                    int surfaceArea = 2 * (a * b + b * c + c * a);
                    if (surfaceArea < minSur_Area) {
                        minSur_Area = surfaceArea;
                        best_A = a;
                        best_B = b;
                        best_C = c;
                    }
                }
            }
        }
        System.out.println(best_C + " " + best_B + " " + best_A);
    }
}
