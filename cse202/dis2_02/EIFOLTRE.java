
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EIFOLTRE {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        HashMap<String, Vertex> vertexs = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String u = sc.next();
            String v = sc.next();
            if (!vertexs.containsKey(u)) {
                vertexs.put(u, new Vertex(u));
            }
            if (!vertexs.containsKey(v)) {
                vertexs.put(v, new Vertex(v));
            }
            vertexs.get(u).addLink(vertexs.get(v));
            vertexs.get(v).addLink(vertexs.get(u));
        }
        vertexs.forEach((key, val) -> {
            val.list.sort((s1, s2) -> {
                return s1.name.compareToIgnoreCase(s2.name);
            });
        });
        String top = sc.next();
        dfs(vertexs.get(top), 0);
        System.out.println(sb);
    }

    static void dfs(Vertex v, int level) {
        v.check = true;
        sb.append("-").append("---".repeat(level)).append(v.name).append("\n");
        for (Vertex ver : v.list) {
            if (!ver.check) {
                dfs(ver, level + 1);
            }
        }
    }

    static class Vertex {

        String name;
        boolean check;
        ArrayList<Vertex> list = new ArrayList<>();

        public Vertex(String name) {
            this.name = name;
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
