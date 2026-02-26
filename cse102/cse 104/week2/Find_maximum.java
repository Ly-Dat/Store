
import java.util.Scanner;

public class Find_maximum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long KQ = 0;
        long min = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] - min > KQ) {
                KQ = arr[i] - min;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(KQ);
    }

}
