
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EIFBF {
    static int maxId = -1, countM, countW; 
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
        ArrayList<Component> comps = new ArrayList<>();
        for(int i=1; i<=n; i++){
            Vertex ver = vertexs[i];
            if(!ver.check){
                dfs(ver);
                Component c = new Component(maxId, countM, countW);
                comps.add(c);
                maxId = -1;
                countM = countW = 0;
            }
        }

        comps.sort((c1, c2)->{
            return Integer.compare(c1.maxId, c2.maxId);
        });
        comps.forEach(co->{
            sb.append(co.maxId+" "+co.countM+" "+co.countW).append("\n");
        });
        System.out.println(sb);
    }
    static void dfs(Vertex v){
        v.check = true;
        maxId = Math.max(maxId, v.id);
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

    }
    static class Component{
        int maxId;
        int countM;
        int countW;
        public Component(int maxId, int countM, int countW) {
            this.maxId = maxId;
            this.countM = countM;
            this.countW = countW;
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
