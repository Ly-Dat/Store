
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = false;
        long top = 0;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long min = arr[0];
        boolean[] up_down = new boolean[n];
        long KQ = 0;

        if (arr[1] >= arr[0]) {
            up_down[0] = true;
        } else {
            up_down[0] = false;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                up_down[i] = true;
            } else if (arr[i] < arr[i - 1]) {
                up_down[i] = false;
            } else {
                up_down[i] = up_down[i - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            if (up_down[i] == false && up_down[i - 1] == true) {
                top = arr[i - 1];
                if (top - min > KQ) {
                    KQ = top - min;
                }
                flag = true;
            }
            if (up_down[i] == true && up_down[i - 1] == false && arr[i - 1] < min) {
                min = arr[i - 1];
                if (i == n - 1) {
                    top = arr[i];
                    if (top - min > KQ) {
                        KQ = top - min;
                    }
                }
                flag = true;
            }
        }
        if (!flag && up_down[n - 1]) {
            KQ = arr[n - 1] - arr[0];
        }
        System.out.println(KQ);

    }
}
