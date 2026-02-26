
import java.util.Arrays;
import java.util.Scanner;

public class EIUPH010 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max_count = 0;
        int count = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < length; i++) {
            if (arr[i] != arr[i - 1]) {
                if (count == max_count) {
                    min = Math.min(min, arr[i - 1]);
                } else if (count > max_count) {
                    max_count = count;
                    min = arr[i - 1];
                }
                count = 0;
            }
            count++;
        }

        if (count == max_count) {
            min = Math.min(min, arr[length - 1]);
        } else if (count > max_count) {
            max_count = count;
            min = arr[length - 1];
        }

        System.out.println(min + " " + max_count);
    }
}
