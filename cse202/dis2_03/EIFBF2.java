import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EIFBF2 {
    static int countM, countW; 
    static ArrayList<Vertex> arr = new ArrayList<>();
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n+1];
        for(int i=1; i<=n; i++){
            vertexs[i] = new Vertex(i);
            vertexs[i].gender = sc.next();
        }
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }

        for(int i=1; i<=n; i++){
            Vertex ver = vertexs[i];
            if(!ver.check){
                dfs(ver);
                for(Vertex vt : arr){
                    vertexs[vt.id].countM = countM;
                    vertexs[vt.id].countW = countW;
                }
                countM = countW = 0;
                arr = new ArrayList<>();
            }
        }

        for(int i=1; i<=n; i++){
            sb.append(vertexs[i]).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(Vertex v){
        arr.add(v);
        v.check = true;
        if(v.gender.equals("Nam")){
            countM++;
        }
        else{
            countW++;
        }
        for(Vertex ver : v.list){
            if(!ver.check){
                dfs(ver);
            }
        }
    }
    static class Vertex{
        int id;
        int countM;
        int countW;
        boolean check;
        String gender;
        ArrayList<Vertex> list = new ArrayList<>();
        public Vertex(int id) {
            this.id = id;
            this.check = false;
        }
        public void addLink(Vertex v){
            list.add(v);
        }

        @Override
        public String toString() {
            return  id + " " + countM + " " + countW ;
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
