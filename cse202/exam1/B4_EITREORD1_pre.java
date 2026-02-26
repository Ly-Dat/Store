import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// input: in, post => pre
public class B4_EITREORD1_pre {
    static int[] inOrder, postOrder;
    static HashMap<Integer, Integer> inIndex = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();

        inOrder = new int[n];
        postOrder = new int[n];

        for (int i = 0; i < n; i++) {
            inOrder[i] = sc.nextInt();
            inIndex.put(inOrder[i], i);
        }

        for (int i = 0; i < n; i++) {
            postOrder[i] = sc.nextInt();
        }

        printPreOrder(0, n - 1, 0, n - 1);
        System.out.println(sb.toString().trim());
    }

    static void printPreOrder(int start, int end, int postL, int postR) {
        if (start > end || postL > postR) return;

        int node = postOrder[postR];
        sb.append(node).append(" ");

        int mid = inIndex.get(node);
        int leftSize = mid - start;

        printPreOrder(start, mid - 1, postL, postL + leftSize - 1);
        printPreOrder(mid + 1, end, postL + leftSize, postR - 1);
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
