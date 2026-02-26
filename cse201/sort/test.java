import java.util.Scanner;

class QUICKSORTT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long a = sc.nextLong();
            long p = sc.nextLong();
            int index = sc.nextInt();
            long arr[] = new long[n];
            
            arr[0] = (a * a) % p;
            for (int j = 1; j < arr.length; j++) {
                arr[j] = (arr[j - 1] * a) % p;
            }
            sb.append(search(arr, 0, n - 1, index)).append("\n");
        }
      
        System.out.println(sb);
    }

    static long search(long arr[], int low, int high, int index) {
        int pi = partition(arr, low, high);
        if (pi == index - 1) {
            return arr[pi];
        }
        if (pi > index - 1) {
            return search(arr, low, pi - 1, index);
        }
        if (pi < index - 1) {
            return search(arr, pi + 1, high, index);
        }
        return 1;
    }

    static void swap(long arr[], int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(long arr[], int left, int right) {
        int pivot = (int) arr[(right + left) / 2];

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }
}
