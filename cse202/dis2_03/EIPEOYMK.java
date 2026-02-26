
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EIPEOYMK {
    static HashMap<Integer, ArrayList<Vertex>> map = new HashMap<>();
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        int uTarget = sc.nextInt();
        int q = sc.nextInt();
        bfs(vertexs[uTarget]);
        for (int i = 0; i < q; i++) {
            int k = sc.nextInt();
            ArrayList<Vertex> arr = map.get(k);
            if (arr == null) {
                sb.append("-1");
            } else {
                arr.sort((s1, s2) -> {
                    return Integer.compare(s1.id, s2.id);
                });
                arr.forEach(s -> {
                    sb.append(s.id + " ");
                });
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(Vertex v) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        v.check = true;
        v.level = 0;
        while (!queue.isEmpty()) {
            Vertex ver = queue.poll();
            for (Vertex a : ver.list) {
                if (!a.check) {
                    queue.add(a);
                    a.check = true;
                    a.level += ver.level + 1;
                    if (!map.containsKey(ver.level + 1)) {
                        ArrayList<Vertex> arr = new ArrayList<>();
                        map.put(ver.level + 1, arr);
                    }
                    ArrayList<Vertex> arr = map.get(ver.level + 1);
                    arr.add(a);
                }
            }
        }
    }

    static class Vertex {

        int id;
        ArrayList<Vertex> list = new ArrayList<>();
        boolean check;
        int level;

        public Vertex(int id) {
            this.id = id;
            this.check = false;
            this.level = 0;
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
