import java.util.*;
import java.io.*;

public class EIUONCE {
    public static void main(String[] args) {
        int tc = reader.nextInt();
        for (int testcase = 0; testcase < tc; testcase++) {
            int num = reader.nextInt();
            HashMap<Integer, Integer> map_num = new HashMap<>();
            for (int i = 0; i < num; i++) {
                int ele = reader.nextInt();
                if (!map_num.containsKey(ele)) {
                    map_num.put(ele, 1);
                } else {
                    map_num.put(ele, map_num.get(ele) + 1);
                }
            }
            List<Integer> list_key = new ArrayList<>(map_num.keySet());
            list_key.sort(null);
            for (Integer ele : list_key) {
                if (map_num.get(ele) == 1) {
                    str.append(ele).append(" ");
                }
            }
            str.append("\n");
        }
        System.out.print(str);
    }

    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

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