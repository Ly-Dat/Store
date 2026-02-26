import java.util.*;
import java.io.*;

public class EIUQUISORT2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var length = sc.nextInt();

        var numbers = new double[length];
        setArray(numbers);

        QuickSort.quickSort(numbers);

        for (double i : numbers) {
            sb.append((int) i).append("\n").append("\n");
        }
        System.out.println(sb);
    }

    private static void setArray(double[] numbers) {
        var adder = .0000001;
        for (int i = 0; i < numbers.length; i++, adder += .0000001) {
            numbers[i] = sc.nextDouble() + adder;
        }
    }

    static class QuickSort {
        public static void quickSort(double[] numbers) {

            quickSort(numbers, 0, numbers.length);
        }

        private static void quickSort(double[] numbers, int start, int end) {
            if (end - start < 2)
                return;
            int middle = partition(numbers, start, end);
            quickSort(numbers, start, middle);
            quickSort(numbers, middle, end);
        }

        private static int partition(double[] numbers, int start, int end) {
            var pivot = pickPivot(numbers, start, end);
            int i = start;
            for (int j = i + 1; j < end; j++) {
                if (Double.compare(numbers[j], pivot) < 0) {
                    swap(numbers, ++i, j);
                }
            }
            swap(numbers, start, i);
            return i;
        }

        private static void swap(double[] numbers, int i, int j) {
            var temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        private static double pickPivot(double[] numbers, int start, int end) {
            var i = start + (end - start) / 2;
            return swapAndReturnValue(numbers, start, i);
        }

        private static double swapAndReturnValue(double[] numbers, int start, int i) {
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
