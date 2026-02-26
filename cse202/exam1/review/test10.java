import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test10 {
    public static void main(String[] args) {
        int T =sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int j =0; j<T; j++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            Vertex[] vertexs = new Vertex[n];
            for (int i = 0; i < n; i++) {
                vertexs[i] = new Vertex(i);
            }
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                vertexs[u].addLink(vertexs[v]);
                vertexs[v].addLink(vertexs[u]);
            }
            boolean flag = true;
            for(var ver : vertexs){
                if(!ver.check){
                    if(!bfs(ver)){
                        flag = false;
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
        v.group = 1;
        Queue<Vertex> queue = new LinkedList();
        queue.add(v);
        while(!queue.isEmpty()){
            Vertex ver = queue.poll();
            for(var ve : ver.list){
                if(!ve.check){
                    ve.check = true;
                    queue.add(ve);
                }
                if(ve.group == ver.group){
                    return false;
                }
                else if(ver.group == 1){
                    ve.group = 2;
                }
                else{
                    ve.group = 1;
                }
            }
        }
        return true;
    }
    static class Vertex {
        int group = 0;
        boolean check = false;
        int id;
        List<Vertex> list = new ArrayList();
        List<Integer> path = new ArrayList();
        public Vertex(int id) {
            this.id = id;
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
