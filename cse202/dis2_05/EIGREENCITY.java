
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EIGREENCITY {

    public static void main(String[] args) {
        int n = sc.nextInt();
        int root = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < vertexs.length; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < vertexs.length - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
            vertexs[u].isRoot = true;
        }
        int leaves = 0;
        for (Vertex vertex : vertexs) {
            if (!vertex.isRoot) {
                leaves++;
            }
        }
        for (int i = 0; i < leaves; i++) {
            vertexs[sc.nextInt()].tree = sc.nextInt();
        }
        dfs(vertexs[root]);
        for (Vertex ver : vertexs) {
            sb.append(ver.id).append(" ").append(ver.tree).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(Vertex v) {
        v.check = true;
        for (Vertex ver : v.list) {
            if (!ver.check) {
                dfs(ver);
                v.tree += ver.tree;
            }
        }
    }

    static class Vertex {

        int id;
        boolean check;
        boolean isRoot;
        int tree;
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
