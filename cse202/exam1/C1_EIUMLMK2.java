
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C1_EIUMLMK2 {

    public static void main(String[] args) {
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        Vertex[] vertexs = new Vertex[n];
        for (int j = 0; j < n; j++) {
            vertexs[j] = new Vertex(j);
        }

        for (int j = 0; j < n - 1; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        for (int i = 0; i < n; i++) {
            vertexs[i].money = sc.nextLong();
        }

        long q = sc.nextLong();
        if (vertexs[0].money >= q) {
            dfs(vertexs[0], q * 110 / 100);
        } 
        for (var ver : vertexs) {
            sb.append(ver.numProduct).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(Vertex v, long m) {
        v.check = true;
        v.numProduct = 1;
        for (var ver : v.list) {
            if (!ver.check) {
                if (ver.money >= m) {
                    dfs(ver, m * 110 / 100);
                } else {
                    v.numProduct += dfsP(ver);
                    count = 0;
                }
            }
        }
    }
    static int count = 0;

    static int dfsP(Vertex v) {
        v.check = true;
        count++;
        for (var ver : v.list) {
            if (!ver.check) {
                dfsP(ver);
            }
        }
        return count;
    }

    static class Vertex {

        int id;
        boolean check;
        long money;
        int numProduct;
        ArrayList<Vertex> list = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
            this.check = false;
        }

        public void addLink(Vertex v) {
            list.add(v);
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
