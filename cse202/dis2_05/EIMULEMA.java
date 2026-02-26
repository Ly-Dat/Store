import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EIMULEMA {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for(int i=0; i<n; i++){
            vertexs[i] = new Vertex(i, sc.nextInt());
        }
        for(int i=0; i<n-1; i++){
            int u = sc.nextInt();
            int v  = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
        }
        for(var item : vertexs){
            item.list.sort((s1, s2)->{
                return Integer.compare(s2.id, s1.id);
            });
        }
        dfs(vertexs[0]);
        for(var ve : vertexs){
            sb.append(ve.id).append(" ").append(ve.money).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(Vertex v){
        v.check = true;
        for (Vertex ver : v.list) {
            if (!ver.check) {
                dfs(ver);
                v.money += ver.money * 1 / 2;
            }
        }
    }
    static class Vertex {
        int money;
        int id;
        boolean check;
        ArrayList<Vertex> list = new ArrayList<>();

        public Vertex(int id, int money) {
            this.id = id;
            this.check = false;
            this.money = money*15/100;
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
