import java.util.*;
import java.io.*;

public class EIUBISEA {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int length = sc.nextInt();
        int nCheck = sc.nextInt();
        int[] numbers = new int[length];
        setArray(numbers);
        Arrays.sort(numbers);
        while (nCheck-- > 0) {
            int key = sc.nextInt();
            sb.append(binarySearch(numbers, key)).append(" ");
        }
        System.out.println(sb);

    }

    private static int binarySearch(int[] numbers, int key) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (numbers[middle] > key) {
                right = middle -1;
            } else if (numbers[middle] == key) {
                return binarySearch(numbers, left, middle + 1, key);
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] numbers, int left, int right, int key) {

        right -= 1;
        int lastKeyAppearance = right;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (numbers[middle] != key) {
                left = middle + 1;
            } else {
                lastKeyAppearance = middle;
                right = middle - 1;
            }

        }
        return lastKeyAppearance;
    }

    private static void setArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
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
