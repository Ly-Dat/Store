import java.util.*;
import java.io.*;

 class EI20213Q2 {
    static InputReader sc = new InputReader(System.in);
    static List<Integer> numsList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var length = sc.nextInt();
        Map<Integer, Integer> numsMap = new HashMap<>();
        setNumsMap(numsMap, length);
        
        numsMap.forEach((k, v) -> {
            numsList.add(k);
        });
        numsList.sort((a, b) -> a - b);

        for (Integer num : numsList) {
            sb.append(num).append(" ").append(numsMap.get(num)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void setNumsMap(Map<Integer, Integer> numsMap, int length) {
        for (int i = 0; i < length; i++) {
            var num = sc.nextInt();
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
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
