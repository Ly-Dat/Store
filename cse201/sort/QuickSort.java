
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    
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
        int middle = left;
        int pivot = arr[left];
        for (int j = left + 1; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, middle + 1, j);
                middle++;
            }
        }
        swap(arr, left, middle);

        //thêm dô thành random quick sort
        int middleL = middle;
        for (int i = middle + 1; i < right; i++) {
            if (arr[i] == pivot) {
                swap(arr, middleL + 1, i);
                middleL++;
            }
        }
        return new int[]{middle, middleL};

    }

    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
