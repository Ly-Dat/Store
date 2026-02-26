import java.util.Arrays;
import java.util.Scanner;

 class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        

        Arrays.sort(arr);
        

        int left = 0;
        int right = arr[N - 1] - arr[0];
        int result = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceKElements(arr, K, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
    
    private static boolean canPlaceKElements(int[] arr, int K, int minDist) {
        int count = 1;
        int lastPlaced = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPlaced >= minDist) {
                count++;
                lastPlaced = arr[i];
                if (count >= K) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
