import java.io.*;
import java.util.*;

public class C2_EIUWBT {
    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int j = 0; j < n; j++) {
            vertexs[j] = new Vertex(j, sc.nextLong());
        }
        for (int j = 0; j < n - 1; j++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }

        Vertex end = new Vertex(-1, 0);
        long min = Long.MAX_VALUE;
        long bestA = 0, bestB = 0;

        for (var ver : vertexs) {
            if (ver.list.size() == 2) { 
                long aTmp = dfs(ver.list.get(0), ver);
                long bTmp = dfs(ver.list.get(1), ver);
                long num = Math.abs(aTmp - bTmp);

                if (num < min || (num == min && ver.id < end.id)) {
                    min = num;
                    end = ver;
                    bestA = aTmp;
                    bestB = bTmp;
                }
            }
        }

        if (end.id == -1) {
            System.out.println("-1");
        } else {
            if (bestA < bestB) {
                System.out.println((end.id + 1) + " " + bestA + " " + bestB);
            } else {
                System.out.println((end.id + 1) + " " + bestB + " " + bestA);
            }
        }
    }

    static long dfs(Vertex v, Vertex parent) {
        long sum = v.weight;
        for (var ver : v.list) {
            if (ver.id != parent.id) {
                sum += dfs(ver, v);
            }
        }
        return sum;
    }

    static class Vertex {
        int id;
        long weight;
        ArrayList<Vertex> list = new ArrayList<>();

        public Vertex(int id, long weight) {
            this.id = id;
            this.weight = weight;
        }

        public void addLink(Vertex v) {
            list.add(v);
        }
    }

    static InputReader sc = new InputReader(System.in);

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
