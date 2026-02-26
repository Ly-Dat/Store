import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class EIMINDISTA {
   
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Vertex [] vertexs = new Vertex[n];
        for(int i = 0; i < n; i++){
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight =  sc.nextInt();
            vertexs[u].list.add(new Edge(weight, vertexs[v]));
            vertexs[v].list.add(new Edge(weight, vertexs[u]));
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>((s1, s2)->{
            return Integer.compare(s1.distance, s2.distance);
        });
        int alt = 0;
        pq.add(vertexs[0]);
        vertexs[0].distance = 0;
        while(!pq.isEmpty()){
            Vertex ver = pq.poll();
            for(Edge ve : ver.list){
                alt = ver.distance + ve.weight;
                if(alt < ve.to.distance){
                    ve.to.distance = alt;
                    pq.add(ve.to);
                }
            }
        }
        for(int i=1; i< vertexs.length; i++){
            if(vertexs[i].distance == Integer.MAX_VALUE){
                sb.append(-1);
            }
            else{
                sb.append(vertexs[i].distance);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
    static class Edge {
        int weight;
        Vertex to;

        public Edge(int weight, Vertex to) {
            this.weight = weight;
            this.to = to;
        }

    }
    
    static class Vertex {
        int id;
        int distance = Integer.MAX_VALUE;
        // int privot;
        List<Edge> list = new ArrayList<>();

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
