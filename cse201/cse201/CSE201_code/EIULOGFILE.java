import java.util.*;
import java.io.*;

public class EIULOGFILE {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        long[] timestamps = new long[sc.nextInt()];

        long count = 0;

        setArray(timestamps);
        Arrays.sort(timestamps);
        for (int i = 0; i < timestamps.length - 1; i++) {

            long limitedTimeLogfile = timestamps[i] + 1_200_001;
            int index = ~Arrays.binarySearch(timestamps, i + 1, timestamps.length, limitedTimeLogfile);

            count += index - i - 1;

        }
        System.out.println(count);
    }

    private static void setArray(long[] timestamps) throws IOException {

        for (int i = 0; i < timestamps.length; i++) {
            timestamps[i] = sc.nextLong() << 1;
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
