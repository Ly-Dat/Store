
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EIMAXHTR {

    static int max;
    static int VertexID = 0;

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        bfs(vertexs[0]);
        int fVertex = VertexID;
        for (Vertex vertex : vertexs) {
            vertex.check = false;
            vertex.level = 0;
        }
        max = 0;
        bfs(vertexs[fVertex]);
        System.out.println(Math.min(fVertex, VertexID) + " " + max);
    }

    static void bfs(Vertex v) {
        Queue<Vertex> q = new LinkedList<>();
        v.check = true;
        q.add(v);

        while (!q.isEmpty()) {
            Vertex ve = q.poll();

            for (Vertex ver : ve.list) {
                if (!ver.check) {
                    ver.check = true;
                    q.add(ver);
                    ver.level = ve.level + 1;

                    if (ver.level > max) {
                        max = ver.level;
                        VertexID = ver.id;
                    } else if (ver.level == max) {
                        VertexID = Math.min(VertexID, ver.id);
                    }

                }
            }
        }
    }

    static class Vertex {

        int height;
        int id;
        boolean check;
        int level = 0;
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
