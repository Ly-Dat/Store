
import java.util.Arrays;
import java.util.Scanner;

public class EI20213Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int listInt = sc.nextInt();
        int[] arr = new int[listInt];
        for (int i = 0; i < listInt; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < listInt; i++) {
            if (arr[i] != arr[i - 1]) {
                sb.append(arr[i - 1] + " " + count+"\n");
                count = 0;
            }
            if (i == listInt - 1) {
                count++;
                sb.append(arr[i] + " " + count+"\n");
            }
            count++;
        }
        System.out.println(sb);
    }
}
