
import java.util.Scanner;

public class Order_of_sequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr_num = new int[n];
        for (int i = 0; i < n; i++) {
            arr_num[i] = sc.nextInt();
        }
        int count_inc = 1;
        int count_dec = 1;
        for (int i = 1; i < n; i++) {
            if (arr_num[i] > arr_num[i - 1]) {
                count_inc += 1;
            }
            else if (arr_num[i] < arr_num[i - 1]) {
                count_dec += 1;
            }
        }
        if (count_inc == n) {
            System.out.println("increasing");
        } else if (count_dec == n) {
            System.out.println("decreasing");
        } else {
            System.out.println("none");
        }
    }
}
