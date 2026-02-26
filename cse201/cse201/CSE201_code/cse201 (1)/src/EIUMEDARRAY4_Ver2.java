import java.util.*;
import java.io.*;

class EIUMEDARRAY4_Ver2 {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        var nTestcases = sc.nextInt();
        QuickSort qs = new QuickSort();
        for (int i = 0; i < nTestcases; i++) {
            qs.numberSmallestKth = -1.0;

            var numbers = new long[sc.nextInt()];
            setNumbers(numbers, sc.nextLong(), sc.nextLong());

            qs.kTH = sc.nextInt() - 1;

            qs.quickSort(numbers);
            sb.append((long) qs.numberSmallestKth).append("\n");
        }
        System.out.println(sb);
    }

    private static void setNumbers(long[] numbers, long a, long p) {
        numbers[0] = a * a % p;
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] * a % p;
        }
    }

    static class QuickSort {

        static double numberSmallestKth;
        static int kTH;

        public static void quickSort(long[] numbers) {
            var partitionedRange = new int[] { 0, numbers.length };
            quickSort(numbers, partitionedRange, 0, numbers.length);
        }

        private static void quickSort(long[] numbers, int[] partitionedRange, int start, int end) {
            if (end - start < 2)
                return;

            int middle = partition(numbers, partitionedRange, start, end);
            if (middle > kTH) {
                quickSort(numbers, partitionedRange, start, middle);
                numberSmallestKth = numbers[kTH];
            } else if (end > kTH) {
                quickSort(numbers, partitionedRange, middle, end);
                numberSmallestKth = numbers[kTH];
            }
        }

        private static int partition(long[] numbers, int[] partitionedRange, int start, int end) {
            var pivot = pickPivot(numbers, start, end);
            var i = start;

            for (int j = i + 1; j < end; j++) {
                if (numbers[j] < pivot) {
                    swap(numbers, ++i, j);
                }
            }
            swap(numbers, start, i);
            return i;
        }

        private static void swap(long[] numbers, int i, int j) {
            var temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        private static double pickPivot(long[] numbers, int start, int end) {
            var i = start + (end - start) / 2;
            return swapAndReturnValue(numbers, start, i);
        }

        private static double swapAndReturnValue(long[] numbers, int start, int i) {
            var temp = numbers[i];
            numbers[i] = numbers[start];
            return (numbers[start] = temp);
        }
    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
