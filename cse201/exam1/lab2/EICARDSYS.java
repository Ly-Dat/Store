
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class EICARDSYS {

    static double result = 0;

    public static void main(String[] args) throws IOException{
        DecimalFormat df = new DecimalFormat("#.##");
        int n = sc.nextInt();
        HashMap<String, ArrayList<Long>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(sc.nextLong());
        }
        map.forEach((key, val) -> {
            result += MemCard(val);
        });
        System.out.println(df.format(result));
    }

    static double MemCard(ArrayList<Long> arr) {
        int mil = 1000000;
        long[] arr_money = {0, 1 * mil, 20 * mil, 50 * mil, 200 * mil, Long.MAX_VALUE};
        double[] rate = {0, 0.02, 0.03, 0.05, 0.07};
        long sum = 0;
        int rank = 0;
        double discount = 0;
        for (int i = 0; i < arr.size(); i++) {
            long money = arr.get(i);
            sum += money;
            discount += money * rate[rank];
            while (true) {
                if (sum >= arr_money[rank + 1]) {
                    rank++;
                } else {
                    break;
                }
            }
        }
        return discount;
    }
static Reader sc = new Reader();
    static StringBuilder sb = new StringBuilder();

    static class Reader {

        private int BUFFER_SIZE = 1 << 16;
        private byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;
        private InputStream rd;

        public Reader() {
            this.rd = System.in;
        }

        private int read() throws IOException {
            if (bufferPointer == bytesRead) {
                bufferPointer = 0;
                bytesRead = rd.read(buffer, bufferPointer, BUFFER_SIZE);
                if (bytesRead == -1) {
                    return -1;
                }
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() throws IOException {
            int number = 0;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                number = number * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return negative ? -number : number;
        }

        public long nextLong() throws IOException {
            long number = 0L;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                number = number * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return negative ? -number : number;
        }

        public String next() throws IOException {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            StringBuilder t = new StringBuilder();
            do {
                t.append((char) c);
                c = read();
            } while (c > ' ');
            return t.toString();
        }

        public String nextLine() throws IOException {
            int c = read();
            while (c == '\n' || c == '\r') {
                c = read();
            }
            StringBuilder t = new StringBuilder();
            while (c != '\n' && c != '\r' && c != -1) {
                t.append((char) c);
                c = read();
            }
            return t.toString();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            return (char) c;
        }
    }
}
