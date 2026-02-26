import java.util.*;
import java.io.*;

public class EITESTING {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nOfSignals = sc.nextInt();
        var a = sc.nextLong();
        var b = sc.nextLong();
        var arrSignals = new ArrayList<Long>(nOfSignals);
        var nOfRecords = sc.nextInt();
        var aPlusb = a + b;

        arrSignals.add(a * a % aPlusb);
        for (int i = 1; i < nOfSignals; i++) {
            arrSignals.add((arrSignals.get(i - 1) + a) * a % aPlusb);
        }

        var mapSignals = new HashMap<Long, Long>();
        for (Long e : arrSignals) {
            mapSignals.put(e, mapSignals.getOrDefault(e, 0L) + 1);
        }

        for (int i = 0; i < nOfRecords; i++) {
            var temp = mapSignals.get(sc.nextLong());
            if (temp != null && temp == sc.nextLong()) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
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
