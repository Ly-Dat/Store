
import java.util.Arrays;
import java.util.Scanner;

class EI2122Q1ADAM2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int[] man = new int[N];
        int[] women = new int[M];
        for (int i = 0; i < N; i++) {
            man[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            women[i] = sc.nextInt();
        }

        Arrays.sort(man);
        Arrays.sort(women);

        int left = 0;
        int right = Math.max(man[N - 1], women[M - 1]) - Math.min(man[0], women[0]);
        int result = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (pairsAvailable(man, women, X, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    public static boolean pairsAvailable(int[] men, int[] women, int X, int H) {
        int pairs = 0, i = 0, j = 0;
        while (i < men.length && j < women.length && pairs < X) {
            if (Math.abs(men[i] - women[j]) <= H) {
                pairs++;
                i++;
                j++;
            } else if (men[i] < women[j]) {
                i++;
            } else {
                j++;
            }
        }
        return pairs >= X;
    }
}
