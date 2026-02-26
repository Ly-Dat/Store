import java.util.*;
import java.io.*;

class EIUPH014 {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		int length = reader.nextInt();
		if (length > 0) {
			do {
				int[] nums = setNums(length);
				int times = calculateLoopTimes(nums);
				sb.append(Integer.toString(times)).append("\n");
				length = reader.nextInt();
			} while (length != 0);
			System.out.println(sb.toString());
		} else {
			System.out.println(0);
		}
	}

	private static int calculateLoopTimes(int[] nums) {
		int count = 0;
		boolean flag = isEqualArray(nums);
		while (!flag && count < 1001) {
			count++;
			int temp = nums[0];
			for (int i = 0; i < nums.length - 1;) {
				nums[i] = Math.abs(nums[i] - nums[++i]);
			}
			nums[nums.length - 1] = Math.abs(nums[nums.length - 1] - temp);
			flag = isEqualArray(nums);
		}
		return (count > 1000) ? -1 : count;
	}

	private static boolean isEqualArray(int[] nums) {
		Set<Integer> numsSet = new HashSet<>();
		for (int e : nums) {
			numsSet.add(e);
		}
		return (numsSet.size() == 1) ? true : false;
	}

	private static int[] setNums(int length) {
		int[] nums = new int[length];
		for (int i = 0; i < length; i++) {
			nums[i] = reader.nextInt();
		}
		return nums;
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
