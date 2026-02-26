import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test5 {
    public static void main(String[] args) {
         int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
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
        for(var ver : vertexs){
            count = 0;
            minIndex = ver.id;
            if(!ver.check){
                dfs(ver);
                sb.append(minIndex).append(" ").append(count).append("\n");
            }
        }
        System.out.println(sb);
    }
    static int count;
    static int minIndex;
    static void dfs(Vertex v){
        v.check = true;
        count++;
        minIndex = Math.min(minIndex, v.id);
        for(var ver : v.list){
            if(!ver.check){
                dfs(ver);
            }
        }
    }
    static class Vertex {
       boolean check = false;
        int id;
        List<Vertex> list = new ArrayList();

        public Vertex(int id) {
            this.id = id;
            
        }

        public void addLink(Vertex v) {
            if(!list.contains(v)){
                list.add(v);
            }
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
