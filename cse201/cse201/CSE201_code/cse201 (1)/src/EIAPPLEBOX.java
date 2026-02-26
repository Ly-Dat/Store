import java.util.*;

 class Count_Inversion {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nTestcases = sc.nextInt();
        Sort s = new Sort();
        while (nTestcases-- > 0) {
            s.countInversion = 0;
            int length = sc.nextInt();
            long a = sc.nextLong();
            long p = sc.nextLong();
            long[] numbers = new long[length];
            setArr(numbers, a, p);
            s.mergeSort(numbers);
            sb.append(s.countInversion).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void setArr(long[] numbers, long a, long p) {
        numbers[0] = (a * a) % p;
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = (numbers[i - 1] * a) % p;
        }
    }

    static class Sort {
        long countInversion;

        public void mergeSort(long[] number) {
            long[] copyArr = new long[number.length];
            mergeSort(number, copyArr, 0, number.length);
        }

        private void mergeSort(long[] number, long[] copyArr, int start, int end) {
            if (end - start < 2)
                return;
            int middle = (end + start) >> 1;
            mergeSort(number, copyArr, start, middle);
            mergeSort(number, copyArr, middle, end);
            merge(number, copyArr, start, middle, end);
        }

        private void merge(long[] number, long[] copyArr, int start, int middle, int end) {
            if (number[middle - 1] <= number[middle])
                return;
            int k = start, i = start, j = middle;
            while (k < end) {
                if (j >= end || (i < middle && number[i] <= number[j])) {
                    copyArr[k++] = number[i++];
                } else if (j < end && number[i] > number[j]) {
                    copyArr[k++] = number[j++];
                    countInversion += middle - i;
                } else if (i >= middle) {
                    copyArr[k++] = number[j++];
                }
            }
            System.arraycopy(copyArr, start, number, start, end - start);
        }
    }
}
