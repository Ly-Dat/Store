import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

 class EIUONCE {

    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);
    static Map<Long, Integer> numbers;

    public static void main(String[] args) {
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            int length = sc.nextInt();
            numbers = getNumbers(length);
            numbers.forEach((key, element) -> {
                if (element == 1) sb.append(key).append(" ");                
            });
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static Map<Long, Integer> getNumbers(int length) {
        numbers = new TreeMap<>();
        for (int i = 0; i < length; i++) {
            long number = sc.nextLong();
            numbers.put(number, numbers.getOrDefault(number, 0) + 1);
        }
        return numbers;
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
