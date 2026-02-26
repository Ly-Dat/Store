
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test_EIFBF {

    static int maxIndex = 0;
    static int countM = 0;
    static int countW = 0;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i, sc.next());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() -1;
            int v = sc.nextInt() -1;
            vertexs[u].list.add(vertexs[v]);
            vertexs[v].list.add(vertexs[u]);
        }
        List<Result> list = new ArrayList<>();
        for (var ver : vertexs) {
            if (!ver.check) {
                maxIndex = 0;
                countM = 0;
                countW = 0;
                dfs(ver);
                list.add(new Result(maxIndex, countM, countW));
            }
        }
        list.sort((s1, s2)->{
            return Integer.compare(s1.id, s2.id); 
        });
        for(var item : list){
            sb.append(item.id+1).append(" ").append(item.countM).append(" ").append(item.countW).append("\n");
        }
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
    static void dfs(Vertex v) {
        v.check = true;
        maxIndex = Math.max(maxIndex, v.id);
        if (v.gender.equals("Nam")) {
            countM++;
        } else {
            countW++;
        }
        for (var ver : v.list) {
            if (!ver.check) {
                dfs(ver);
            }
        }
    }

    static class Vertex {

        String gender;
        int id;
        boolean check;
        List<Vertex> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public Vertex(int id, String gender) {
            this.id = id;
            this.gender = gender;
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
