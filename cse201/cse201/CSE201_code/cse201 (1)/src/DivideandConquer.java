import java.util.*;

public class DivideandConquer {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nTestcases = sc.nextInt();

        // for (int i = 0; i < nTestcases; i++) {
        //     var length = sc.nextInt();
        //     Arr numbers = new Arr(length);
        //     numbers.setArr();
        //     var nOperations = 0;
        //     if (numbers.sum % 2 != 0) {
        //         while (true) {
        //             numbers.sum -= numbers.minNumber;
        //             numbers.sum += numbers.minNumber /= 2;
        //             nOperations++;
        //             if (numbers.sum % 2 == 0) {
        //                 break;
        //             }
        //         }
        //     }
        //     sb.append(nOperations).append("\n");
        // }

        // System.out.println(sb);
    }

    private static int findMinnumber(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

    private static long getSum(int[] numbers) {
        long sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }

    private static void setArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    static class Arr {
        int[] arr;
        long sum;
        int minOdd = -1;
        int minEven = -1;

        public Arr(int n) {
            this.arr = new int[n];
            calSum();
            findMinOddAndMinEven();
        }

        private void findMinOddAndMinEven() {
            for (int i : arr) {

            }
        }

        private void calSum() {
            for (int i : arr) {
                sum += i;
            }
        }

        public void setArr() {
            for (int i : arr) {
                i = sc.nextInt();
            }
        }
    }
}
