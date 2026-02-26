import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EI2122Q1DSAF1 {
    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nWorkers = rd.nextInt();
        Map<Integer, Worker> mapWorkers = new TreeMap<>();
        while (nWorkers-- > 0) {
            int id = rd.nextInt();
            long quantity = rd.nextLong();
            long soldPrice = rd.nextLong();
            if (!mapWorkers.containsKey(id)) {
                mapWorkers.put(id, new Worker(id, soldPrice * quantity));
            } else {
                mapWorkers.get(id).totalRevenue += soldPrice * quantity;
            }
        }
        List<Worker> listWorkers = new ArrayList<>(mapWorkers.values());
        listWorkers.sort((a, b) -> {
            return Long.compare(b.totalRevenue, a.totalRevenue);
        });

        for (Worker worker : listWorkers) {
            sb.append(worker).append("\n").append("\n");
        }
        System.out.println(sb);
    }

    static class Worker {
        int id;
        long totalRevenue;

        public Worker(int id, long totalRevenue) {
            this.id = id;
            this.totalRevenue = totalRevenue;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(this.id).append(" ").append(this.totalRevenue).append(" ").toString();
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
