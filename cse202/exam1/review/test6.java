
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test6 {

    public static void main(String[] args) {
         int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i, sc.next());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        List<Result> results = new ArrayList<>();
        for(var ver : vertexs){
            countM = 0;
            countW = 0;
            max = 0;
            if(!ver.check){
                dfs(ver);
                results.add(new Result(max, countM, countW));
            }
        }
        results.sort((s1, s2)->{
            return Integer.compare(s1.id, s2.id);
        });
        results.forEach(a->{
            sb.append(a.id+1).append(" ").append(a.countM).append(" ").append(a.countW).append("\n");
        });
        System.out.println(sb);

    }
    static class Result{
        int id;
        int countM;
        int countW;
        public Result(int id, int countM, int countW) {
            this.id = id;
            this.countM = countM;
            this.countW = countW;
        }
        
    }
    static int countM;
    static int countW;
    static int max;
    static void dfs(Vertex v){
        v.check = true;
        max = Math.max(max, v.id);
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
