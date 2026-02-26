import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.StringTokenizer;

 class PracticeMakesPerfect {
    
   

    public static void main(String[] args) {

        int n = sc.nextInt();
        int root  = sc.nextInt();

        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < vertexs.length; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < vertexs.length - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].add(vertexs[v]);
            vertexs[v].add(vertexs[u]);
            vertexs[u].isRoot = true;
        }
        int count = 0;
        for (Vertex vertex : vertexs) {
            if (!vertex.isRoot) {
                count++;
            }
        }
        for (int i = 0; i < count; i++) {
            vertexs[sc.nextInt()].water = sc.nextInt();
        }
        dfs(vertexs[root]);
        for (Vertex vertex : vertexs) {
            sb.append(vertex.id).append(" ").append(vertex.water).append("\n");
        }
       
        
        
        

        
        System.out.println(sb);
       
    }

    static void dfs(Vertex v) {
        v.visited = true;
        for (Vertex w : v.adj) {
            if (!w.visited) {
                dfs(w);
                v.water += w.water ;
            }

        }

    }

    

  

    static class Vertex {

        int id;
        int water;
        boolean isRoot;
        boolean visited;

        List<Vertex> adj = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
            
        }

        public void add(Vertex v) {
            adj.add(v);
        }

    }

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

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
