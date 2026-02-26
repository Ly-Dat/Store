import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B7_EILOCALA {
    static int max = 0;
    static int minIndex =0;
    public static void main(String[] args) {
        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < n-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            vertexs[u].addLink(new Edge(vertexs[v], weight));
            vertexs[v].addLink(new Edge(vertexs[u], weight));
        }
        int min1 = dfs(vertexs[0]);
        for(var ver : vertexs){
            ver.check = false;
            ver.weight = 0;
        }
        int min2  = dfs(vertexs[min1]);
        System.out.println(Math.min(min1, min2)+" "+max);

    }
    static int dfs(Vertex v){
        v.check = true;
        if(v.weight > max){
            max = v.weight;
            minIndex = v.id;
        }
        for(Edge e : v.list){
            if(!e.end.check){
                e.end.weight = e.weight + v.weight;
                dfs(e.end);
            }
        }
        return minIndex;
    }
    static class Vertex{
        int id;
        boolean check;
        int weight;
        List<Edge> list = new ArrayList<>();
        public Vertex(int id){
            this.id = id;
        }
        public void addLink(Edge e){
            list.add(e);
        }
    }
    static class Edge{
        Vertex end;
        int weight;
        public Edge(Vertex end, int weight) {
            this.end = end;
            this.weight = weight;
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
