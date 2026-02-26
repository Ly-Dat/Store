import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class A13_EIFBF {
    static int maxIndex;
    static int countW;
    static int countM;
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
        List<Result> list1 = new ArrayList<>();
        for (var item : vertexs) {
            if (!item.check) {
                countW = 0;
                countM = 0;
                maxIndex = 0;
                dfs(item);
                Result result = new Result(maxIndex+1, countM, countW);
                list1.add(result);
            }
        }
        list1.sort((s1, s2)->{
            return Integer.compare(s1.index, s2.index);
        });
        for(var item : list1){
            sb.append(item.index).append(" ").append(item.countM).append(" ").append(item.countW).append("\n");
        }
        System.out.println(sb);
    }
    static class Result{
        int index;
        int countM;
        int countW;

        public Result(int index, int countM, int countW) {
            this.countM = countM;
            this.countW = countW;
            this.index = index;
        }
        
    }
    static void dfs(Vertex v) {
        v.check = true;
        if(v.gender.equals("Nam")){
            countM++;
        }
        else{
            countW++;
        }
        maxIndex = Math.max(maxIndex, v.id);
        for (var ve : v.list) {
            if (!ve.check) {
                dfs(ve);
            }
        }
    }
    static class Vertex {
        String gender;
        int id;
        boolean check;
        List<Vertex> list = new ArrayList<>();

        public Vertex(int id, String gender) {
            this.id = id;
            this.check = false;
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
