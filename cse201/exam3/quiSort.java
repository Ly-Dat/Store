
import java.util.Random;
import java.util.Scanner;

public class quiSort {

    static Random rd = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb);
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left + 1 >= right) {
            return;
        }
        int[] mid = divide(arr, left, right);
        quickSort(arr, left, mid[0]);
        quickSort(arr, mid[1] + 1, right);

    }

    static int[] divide(int[] arr, int left, int right) {
        swap(arr, left, rd.nextInt(right - left) + left);
        int mid = left;
        long pivot = arr[left];
        for (int i = left + 1; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, mid + 1, i);
                mid++;
            }
        }
        swap(arr, left, mid);
        int mid2 = mid;
        for (int i = mid + 1; i < right; i++) {
            if (arr[i] == pivot) {
                swap(arr, mid2 + 1, i);
                mid2++;
            }
        }
        return new int[]{mid, mid2};
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
