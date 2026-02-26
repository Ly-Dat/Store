import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class EIPICNIC {
    static InputReader sc;

    static {
        sc = new InputReader(System.in);
    }

    EIPICNIC() {
    }

    public static void main(String[] args) {
        int numberOfGroups = sc.nextInt();
        long[] peopleInGroups = getPeopleInGroups(numberOfGroups);
        long count = 0L;
        count += peopleInGroups[4];
        count += peopleInGroups[3];
        peopleInGroups[1] -= peopleInGroups[3];
        count += peopleInGroups[2] / 2L + peopleInGroups[2] % 2L;
        if (peopleInGroups[2] % 2L != 0L) {
            peopleInGroups[1] -= 2L;
        }

        if (peopleInGroups[1] > 0L) {
            count += peopleInGroups[1] / 4L;
            if (peopleInGroups[1] % 4L != 0L) {
                ++count;
            }
        }

        System.out.println(count);
    }

    private static long[] getPeopleInGroups(int numberOfGroups) {
        long[] peopleInGroups = new long[5];

        for (int i = 0; i < numberOfGroups; ++i) {
            int numberOfPeople = sc.nextInt();
            long var10002 = peopleInGroups[numberOfPeople]++;
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
