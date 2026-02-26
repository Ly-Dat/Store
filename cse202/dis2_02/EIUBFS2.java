
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EIUBFS2 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int j = 0; j < m; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        for (Vertex v : vertexs) {
            v.list.sort((s1, s2) -> {
                return Integer.compare(s1.id, s2.id);
            });
        }
        bfs(vertexs[0]);
        System.out.println(sb);
    }

    static void bfs(Vertex v) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        v.check = true;
        while (!queue.isEmpty()) {
            Vertex ver = queue.poll();
            sb.append(ver.id + " ");
            for (Vertex a : ver.list) {
                if (!a.check) {
                    queue.add(a);
                    a.check = true;
                }
            }
        }
    }

    static class Vertex {

        int id;
        boolean check;
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
