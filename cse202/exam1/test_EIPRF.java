
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

public class test_EIPRF {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for(int i=0; i<n; i++){
            vertexs[i] = new Vertex(i);
        }
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].list.add(vertexs[v]);
            if(v==0){
                vertexs[u].hasZero = true;
            }
        }
        bfs(vertexs[0]);
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(var a : vertexs){
            if(a.path.size()>2 && a.hasZero){
                if(a.path.size()<min){
                    min = a.path.size();
                    index = a.id;
                }
            }
        }
        for(var ver : vertexs[index].path){
            sb.append(ver).append(" ");
        }
        System.out.println(sb);
    }
    static void bfs(Vertex v){
        Queue<Vertex> queue = new LinkedList<>();
        v.check=true;
        queue.add(v);
        while(!queue.isEmpty()){
            Vertex ver = queue.poll();
            ver.path.add(ver.id);
            for(var ve : ver.list){
                if(!ve.check){
                    ve.check = true;
                    queue.add(ve);
                    ve.path.addAll(ver.path);
                }
            }
        }
    }
    static class Vertex {
        boolean hasZero = false;
        int id;
        boolean check;
        List<Vertex> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
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
