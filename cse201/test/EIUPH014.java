
import java.util.Scanner;

public class EIUPH014 {

    static boolean checkSame(int[] arr) {
        int test = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (test != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int length = sc.nextInt();
            if (length == 0) {
                break;
            }
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
            }
            int count = 0;
            while (!checkSame(arr)) {
                if (count == 1000) {
                    count = -1;
                    break;
                }
                int first = arr[0];
                for (int i = 0; i < length - 1; i++) {
                    arr[i] = Math.abs(arr[i + 1] - arr[i]);
                }
                arr[length - 1] = Math.abs(arr[length - 1] - first);
                count++;
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
