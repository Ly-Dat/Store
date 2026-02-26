import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B10_EIMULEMA {
    public static void main(String[] args) {
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Vertex[] vertexs = new Vertex[n];
        for(int i=0; i<n; i++){
            vertexs[i] = new Vertex(i, sc.nextInt());
        }
        for(int i=0; i<n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
        }
        for(var ve : vertexs){
            ve.list.sort((s1, s2)->{
                return Integer.compare(s1.id, s2.id);
            });
        }
        dfs(vertexs[0]);
        for(var ver : vertexs){
            sb.append(ver.id).append(" ").append(ver.money).append("\n");
        }
        System.out.println(sb);

    }
    static void dfs(Vertex v){
        v.check = true;
        for(var ver : v.list){
            if(!ver.check){
                dfs(ver);
                v.money += ver.money/2;
            }
        }
    }
     static class Vertex{
        int id;
        int money;
        boolean check = false;
        List<Vertex> list = new ArrayList<>();
        public Vertex(int id, int money) {
            this.id = id;
            this.money = money*15/100;
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
