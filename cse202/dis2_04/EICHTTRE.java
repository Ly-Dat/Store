import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EICHTTRE {
    static boolean flag;
    public static void main(String[] args) {
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            flag = true;
            int n = sc.nextInt();
            int m = sc.nextInt();
            Vertex[] vertexs = new Vertex[n];
            for(int j=0; j<n; j++){
                vertexs[j] = new Vertex(j);
            }
            for(int j=0; j<m; j++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                vertexs[u].addLink(vertexs[v]);
                vertexs[v].addLink(vertexs[u]);
            }
            if(n-1 != m){
                sb.append("NO").append("\n");
            }
            else{
                dfs(vertexs[0]);
                sb.append(isTree(vertexs)).append("\n");
            }
        }
        System.out.println(sb);
    }
    static void dfs(Vertex v){
        v.check = true;
        for(Vertex ver : v.list){
            if(!ver.check){
                dfs(ver);
            }
        }
    }
    static String isTree(Vertex[] v){
        for(Vertex ver : v){
            if(!ver.check){
                return "NO";
            }
        }
        return "YES";
        
    }
    static class Vertex{
        int id;
        boolean check;
        ArrayList<Vertex> list = new ArrayList<>();
        public Vertex(int id) {
            this.id = id;
            this.check = false;
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