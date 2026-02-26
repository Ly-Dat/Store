import java.util.*;
import java.io.*;

 class EIUMERSORT {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var length = sc.nextInt();
        int[] numbers = new int[length];
        setNumbers(numbers);
        MergeSort.mergeSort(numbers);

        for (int i : numbers) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void setNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    

static class MergeSort {
    
    public static void mergeSort(int[] numbers) {
        int[] copyArray = new int[numbers.length];
        mergeSort(numbers, copyArray, 0, numbers.length);

    }

    private static void mergeSort(int[] numbers, int[] copyArray, int start, int end) {
        if (end - start < 2)
            return;
        var middle = (end + start) >> 1;
        mergeSort(numbers, copyArray, start, middle);
        mergeSort(numbers, copyArray, middle, end);
        merge(numbers, copyArray, start, middle, end);
    }

    private static void merge(int[] numbers, int[] copyArray, int start, int middle, int end) {
        if (numbers[middle - 1] <= numbers[middle])
            return;

        for (int i = start, j = middle, k = i; k < end; k++) {
            if (j >= end || (i < middle && numbers[i] <= numbers[j])) {
                copyArray[k] = numbers[i++];
            } else if (i >= middle || (j < end && numbers[i] > numbers[j])) {
                copyArray[k] = numbers[j++];
            }
        }
        System.arraycopy(copyArray, start, numbers, start, end - start);
        // System.arraycopy(copyArray, i, numbers, k, middle - i);
      
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
