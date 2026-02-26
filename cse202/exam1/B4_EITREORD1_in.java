import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// input: pre, post => in
public class B4_EITREORD1_in {
    static int[] preOrder, postOrder;
    static int index = 0;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> postIndex = new HashMap<>();

    public static void main(String[] args) {
        int n = sc.nextInt();
        preOrder = new int[n];
        postOrder = new int[n];

        for (int i = 0; i < n; i++) {
            preOrder[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            postOrder[i] = sc.nextInt();
            postIndex.put(postOrder[i], i);
        }

        printInOrder(0, n - 1);
        System.out.println(sb);
    }

    static void printInOrder(int start, int end) {
        if (start > end) return;
        int node = preOrder[index++];

        if (start == end) {
            sb.append(node).append(" ");
            return;
        }

        int leftRoot = preOrder[index];
        int mid = postIndex.get(leftRoot);

        printInOrder(start, mid);  
        sb.append(node).append(" ");
        printInOrder(mid + 1, end - 1);
    }

    static InputReader sc = new InputReader(System.in);

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
