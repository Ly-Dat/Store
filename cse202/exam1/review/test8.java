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

public class test8 {
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            if(v == 0){
                vertexs[u].hasZero = true;
            }
        }
        bfs(vertexs[0]);
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(var ver : vertexs){
            if(ver.path.size()>2 && ver.hasZero){
                if(ver.path.size()<min){
                    min = ver.path.size();
                    minIndex = ver.id;
                }
            }
        }
        vertexs[minIndex].path.forEach(a->{
            sb.append(a).append(" ");
        });
        System.out.println(sb);
    }
    static void bfs(Vertex v){
        v.check = true;
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        while(!queue.isEmpty()){
            Vertex ver = queue.poll();
            ver.path.add(ver.id);
            for(var ve : ver.list){
                if(!ve.check){
                    ve.check = true;
                    ve.path.addAll(ver.path);
                    queue.add(ve);
                }
            }
        }
    }
    static class Vertex {
        int level = 0;
        boolean check = false;
        int id;
        boolean hasZero = false;
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
