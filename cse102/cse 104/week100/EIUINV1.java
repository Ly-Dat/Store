
import java.util.*;

class Main {

    static double find_sum(int[] arr, double r) {
        double sum = 0.0;
        for (int i = 0; i < 12; i++) {
            sum += arr[i] * Math.pow(1 + r, 11 - i);
        }
        return sum;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        long money = sc.nextLong();
        int[] arr_money = new int[12];
        for (int i = 0; i < 12; i++) {
            arr_money[i] = sc.nextInt();
        }

        double tolerance = 1e-6;
        double left = 0.0;
        double right = 1.0;
        double rate = 0.0;
        while ((right - left) > tolerance) {
            rate = (left + right) / 2.0;
            double sum = find_sum(arr_money, rate);

            if (sum < money) {
                left = rate;
            } else {
                right = rate;
            }
        }
        System.out.printf("%.3f", rate);
    }
}
