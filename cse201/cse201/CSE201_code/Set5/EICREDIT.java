import java.io.*;
import java.util.StringTokenizer;

public class EICREDIT {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        int numberOfStudents = sc.nextInt();
        for (int i = 0; i < numberOfStudents; i++) {
            String name = sc.next();
            int n = sc.nextInt();
            int tinchi = 0;
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() >= 50) {
                    tinchi += 4;
                }
            }
            sb.append(name + " " + tinchi + "\n");
        }
        System.out.println(sb);
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