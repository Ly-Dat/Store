
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// input: pre, in => post
public class B4_EITREORD {
    static HashMap<Integer, Integer> inOrder = new HashMap<>();
    static int[] preOrder;
    static int index = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int n = sc.nextInt();
        preOrder = new int[n];
        for(int i=0; i<n ; i++){
            preOrder[i] = sc.nextInt();
        }
        for(int i=0; i<n ; i++){
            inOrder.put(sc.nextInt(), i);
        }
        printPostOrder(0, n);
        System.out.println(sb);
    }
    static void printPostOrder(int start, int end){
        if(start >= end){
            return;
        }
        int node = preOrder[index++];
        printPostOrder(start, inOrder.get(node));
        printPostOrder(inOrder.get(node)+1, end);
        sb.append(node).append(" ");
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
