
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class EIBIPARTITE {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i = 0; i<T; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            Vertex[] vertexs = new Vertex[n];
            for(int j=0; j<n; j++){
                vertexs[j] = new Vertex(j);
            }
            for(int j=0; j<m; j++){
                int u= sc.nextInt();
                int v = sc.nextInt();
                vertexs[u].addLink(vertexs[v]);
                vertexs[v].addLink(vertexs[u]);
            }
            boolean flag = true;
            for (Vertex vertex : vertexs) {
                if (!vertex.check) {
                   if (!bfs(vertex)) {
                    flag =  false;
                        break;
                   }
                }
           }
            if(flag){
                sb.append("Yes");
            }
            else{
                sb.append("No");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static boolean bfs(Vertex v){
        v.check = true;
        v.color = 0;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            Vertex vt = queue.poll();
            for(Vertex ver : vt.list){
                if(!ver.check){
                    ver.color = 1 - vt.color;
                    ver.check = true;
                    queue.add(ver);
                }
                else if(vt.color == ver.color){
                    return false;
                }
            }
        }
        return true;
    }
    static class Vertex{
        int id;
        boolean check;
        int color;
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

