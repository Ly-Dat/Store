import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A3_EIHCON {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        Vertex[] vertexs = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[v].addLink(vertexs[u]);
        }
        for (int i=0; i<q; i++){
            int a =sc.nextInt();
            int b = sc.nextInt();
            boolean flag = isConnect(vertexs, a, b);
            if(flag){
                sb.append("Y").append("\n");
            }
            else{
                sb.append("N").append("\n");
            }
        }
        System.out.print(sb);
    }
    static boolean isConnect(Vertex[] vertexs, int a, int b){
        if(vertexs[a].list.contains(vertexs[b])){
            return true;
        }
        for(var item : vertexs[a].list){
            if(item.list.contains(vertexs[b])){
                return true;
            }
        }
        return false;
    }
    static class Vertex{
        int id;
        List<Vertex> list = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }
        public void addLink(Vertex v){
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
