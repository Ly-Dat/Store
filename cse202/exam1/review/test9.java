
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test9 {

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
        for(var ver : vertexs){
            com = new ArrayList<>();
            countM = 0;
            countW = 0;
            if(!ver.check){
                dfs(ver);
                for(var ve : com){
                    ve.countM = countM;
                    ve.countW = countW;
                }
            }
        }
        for(var ver : vertexs){
            sb.append(ver.id+1).append(" ").append(ver.countM).append(" ").append(ver.countW).append("\n");
        }
        System.out.println(sb);
    }
    static List<Vertex> com;
    static int countM;
    static int countW;
    static int max;
    static void dfs(Vertex v){
        v.check = true;
        com.add(v);
        if(v.gender.equals("Nam")){
            countM++;
        }
        else{
            countW++;
        }
        for(var ver : v.list){
            if(!ver.check){
                dfs(ver);
            }
        }
    }
    static class Vertex {
        int countM;
        int countW;
        boolean check = false;
        int id;
        String gender;
        List<Vertex> list = new ArrayList();

        public Vertex(int id, String gender) {
            this.id = id;
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
