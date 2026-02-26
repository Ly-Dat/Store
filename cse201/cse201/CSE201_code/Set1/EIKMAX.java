import java.io.*;
import java.util.*;

public class EIKMAX {
    public static void main(String[] args) {
        int size = reader.nextInt();
        int target = reader.nextInt();
        List<Integer> list= new ArrayList<>(size);
        for(int i = 0 ;i<size;i++){
            list.add(reader.nextInt());
        }
        Collections.sort(list);
        for(int i = 0;i<target;i++){
            sb.append(list.get(list.size()-1)).append(" ");
            list.remove(list.size()-1);
        }
        System.out.println(sb);

    }

    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
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

