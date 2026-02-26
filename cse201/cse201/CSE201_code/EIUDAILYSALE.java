
import java.io.*;
import java.util.*;

public class EIUDAILYSALE {
    static InputReader scanner = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        
        int N = scanner.nextInt();
        // Consume newline

        TreeMap<Long, DayInfo> dayInfoMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            long date = scanner.nextLong();
            long productCode = scanner.nextLong();
            long quantity = scanner.nextLong();
            long sellingPrice = scanner.nextLong();
            // Consume newline

            if (!dayInfoMap.containsKey(date)) {
                dayInfoMap.put(date, new DayInfo());
            }

            DayInfo dayInfo = dayInfoMap.get(date);
            dayInfo.totalQuantity += quantity;
            dayInfo.totalRevenue += quantity * sellingPrice;
        }
       
        // Determine the range of dates from minimum to maximum
        long minDate = dayInfoMap.isEmpty() ? 0 : dayInfoMap.firstKey();
        long maxDate = dayInfoMap.isEmpty() ? 0 : dayInfoMap.lastKey();

        // Output the results from minDate to maxDate
        
        for (long date = minDate; date <= maxDate; date++) {
            if (dayInfoMap.containsKey(date)) {
                DayInfo dayInfo = dayInfoMap.get(date);
                sb.append(date).append(" ").append(dayInfo.totalQuantity).append(" ").append(dayInfo.totalRevenue).append("\n");
            } else {
                sb.append(date).append(" 0 0\n");
            }
        }
        System.out.print(sb.toString());
    }

    static class DayInfo {
        long totalQuantity;
        long totalRevenue;

        public DayInfo() {
            this.totalQuantity = 0;
            this.totalRevenue = 0;
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
