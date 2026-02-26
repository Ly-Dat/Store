
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EIMKF {

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        int accounts = sc.nextInt();
        int relation = sc.nextInt();
        vertex[] vertexs = new vertex[accounts];
        for (int i = 0; i < accounts; i++) {
            vertexs[i] = new vertex(i);
        }
        for (int i = 0; i < relation; i++) {
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            vertexs[a1].addLink(vertexs[b1]);
            vertexs[b1].addLink(vertexs[a1]);
        }
        for (vertex a : vertexs) {
            result.append(a.toString()).append("\n");
        }
        System.out.println(result);

    }

    static class vertex {

        int id;
        List<vertex> list = new ArrayList<>();

        public vertex(int id) {
            this.id = id;
        }

        public void addLink(vertex v) {
            list.add(v);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(id + " " + list.size() + " ");
            list.sort((s1, s2) -> {
                return Integer.compare(s1.id, s2.id);
            });
            for (vertex a : list) {
                sb.append(a.id).append(" ");
            }
            return sb.toString();
        }

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

