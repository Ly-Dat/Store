import java.util.*;
import java.io.*;

class EIUQUISORT {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var length = sc.nextInt();

        var numbers = new int[length];
        setArray(numbers);

        QuickSort.quickSort(numbers);

        for (int i : numbers) {
            sb.append(i).append("\n").append("\n");
        }
        System.out.println(sb);
    }

    private static void setArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    static class QuickSort {
        public static void quickSort(int[] numbers) {

            quickSort(numbers, 0, numbers.length);
        }

        private static void quickSort(int[] numbers, int start, int end) {
            if (end - start < 2)
                return;
            int[] partitionedRange = partition(numbers, start, end);
            quickSort(numbers, start, partitionedRange[0]);
            quickSort(numbers, partitionedRange[1] + 1, end);
        }

        private static int[] partition(int[] numbers, int start, int end) {
            int pivot = pickPivot(numbers, start, end);
            int lt = start - 1, gt = end;
            int temp = -1; // store index that it's value equals to pivot
            int i = start + 1;
            if (numbers[gt] <numbers[lt]){
                swap(numbers, lt, gt--);
            }
            for (; i < gt; i++) {
                if (numbers[i] < pivot) {
                    swap(numbers, ++lt, i);
                } else if (numbers[i] > pivot) {
                    swap(numbers, gt--, i);
                }
            }
           
            return new int[] { lt, gt };
        }

        private static int pickPivot(int[] numbers, int start, int end) {
            int i = start + ((end - start) >> 1);
            return swapAndReturnValue(numbers, start, i);
        }

        private static int swapAndReturnValue(int[] numbers, int start, int i) {
            var temp = numbers[i];
            numbers[i] = numbers[start];
            return (numbers[start] = temp);
        }

        private static void swap(int[] numbers, int i, int j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

    }
}
