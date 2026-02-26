import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class EIPAIR {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static long count;
    public static void main(String[] args) {
        int testcase = reader.nextInt();
    
        for(int i =0;i<testcase;i++){
            int ele = reader.nextInt();
            Map<Integer,Integer> prices = new HashMap<>();
            for(int r =0;r<ele;r++){
                int price = reader.nextInt();
                prices.put(price, prices.getOrDefault(price,0)+1);
            }
            count = 0L;
            prices.forEach((k, v) -> {
               count += (long)v * ((long)v - 1L) >> 1;
            });
            sb.append(count).append("\n");
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
