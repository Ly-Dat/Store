import java.util.*;
import java.io.*;

 class EIPAIR {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static long count;

    public static void main(String[] args) {
        var numOfTestcases = sc.nextInt();

        for (int i = 0; i < numOfTestcases; i++) {
            Map<Integer, Integer> pricesMap = new HashMap<>();
            var length = sc.nextInt();

            for (int j = 0; j < length; j++) {
                var price = sc.nextInt();
                pricesMap.put(price, pricesMap.getOrDefault(price, 0) + 1);
            }
            count = 0;
            pricesMap.forEach((k, v) -> {
                count += (v * (v - 1L)) >> 1;
            });
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
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
