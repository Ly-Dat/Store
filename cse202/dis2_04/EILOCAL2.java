
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EILOCAL2 {

    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for(int i=0; i<n; i++){
            vertexs[i] = new Vertex(i);
        }
        for(int i=0; i<n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
           vertexs[u].addLink(new Edge(vertexs[v], w));
           vertexs[v].addLink(new Edge(vertexs[u], w));
        }

        dfs(vertexs[0]);
        System.out.println(max);

        
    }
    static int max;
    static void dfs(Vertex v){
        v.check = true;
        for(Edge e : v.list){
            if(!e.end.check){
                e.end.len = e.len + v.len;
                max = Math.max(max, e.end.len);
                dfs(e.end);
            }
        }
    }

    static class Edge{
        Vertex end;
        int len;
        public Edge(Vertex end, int len) {
            this.end = end;
            this.len = len;
        }
        
    }
    static class Vertex{
        int id;
        int len;
        boolean check;
        ArrayList<Edge> list = new ArrayList<>();
        public Vertex(int id) {
            this.id = id;
            this.check = false;
        }
        public void addLink(Edge e){
            list.add(e);
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