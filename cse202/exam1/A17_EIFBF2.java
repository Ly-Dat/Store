
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A17_EIFBF2 {

    static int countW;
    static int countM;
    static List<Vertex> com;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i, sc.next());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        for (var item : vertexs) {
            if (!item.check) {
                com = new ArrayList<>();
                countW = 0;
                countM = 0;
                dfs(item);
                for(var ver : com){
                    ver.countM = countM;
                    ver.countW = countW;
                }
            }
        }
        for(var ve :vertexs ){
            sb.append(ve.id+1).append(" ").append(ve.countM).append(" ").append(ve.countW).append("\n");
        }
        System.out.println(sb);

    }
    static void dfs(Vertex v) {
        v.check = true;
        com.add(v);
        if (v.gender.equals("Nam")) {
            countM++;
        } else {
            countW++;
        }
        for (var ve : v.list) {
            if (!ve.check) {
                dfs(ve);
            }
        }
    }

    static class Vertex {
        int countM = 0;
        int countW = 0;
        String gender;
        int id;
        boolean check;
        List<Vertex> list = new ArrayList<>();

        public Vertex(int id, String gender) {
            this.id = id;
            this.check = false;
            this.gender = gender;
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
