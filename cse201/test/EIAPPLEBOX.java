
import java.util.Scanner;

public class EIAPPLEBOX {

    static long[] temp;

    static void mergeSort(long[] arr) {
        temp = new long[arr.length];
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(long[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    static long count = 0;

    static void merge(long[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid + 1 - i;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int m = left; m <= right; m++) {
            arr[m] = temp[m];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testcase = sc.nextInt();
        // long[] arr = new long[testcase];

        // for (int i = 0; i < arr.length; i++) {
        //     arr[i]= sc.nextLong();
        // }
        // mergeSort(arr);
        // for (Object elem : arr) {
        //     System.out.println(elem);
        // }
        for (int t = 0; t < testcase; t++) {
            int lenght = sc.nextInt();
            long A = sc.nextLong();
            long P = sc.nextLong();
            long[] arr = new long[lenght];
            count = 0;
            arr[0] = (A * A) % P;
            for (int i = 1; i < lenght; i++) {
                arr[i] = (arr[i - 1] * A) % P;
            }
            mergeSort(arr);
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
