import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * EIPICNIC
 */
 class EIPICNIC {

    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        int numberOfGroups = sc.nextInt();
        long[] peopleInGroups = getPeopleInGroups(numberOfGroups);

        long count = 0;
        count += peopleInGroups[4];

        count += peopleInGroups[3];
        peopleInGroups[1] -= peopleInGroups[3];

        count += peopleInGroups[2] / 2 + peopleInGroups[2] % 2;
        if (peopleInGroups[2] % 2 != 0) {
            peopleInGroups[1] -= 2;
        }
        
        if (peopleInGroups[1] > 0) {
            count += peopleInGroups[1] / 4;
            if (peopleInGroups[1] % 4 != 0) {
                count += 1;
            }
        }
        System.out.println(count);

    }

    private static long[] getPeopleInGroups(int numberOfGroups) {
        long[] peopleInGroups = new long[5];
        for (int i = 0; i < numberOfGroups; i++) {
            int numberOfPeople = sc.nextInt();
            peopleInGroups[numberOfPeople]++;
        }
        return peopleInGroups;
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