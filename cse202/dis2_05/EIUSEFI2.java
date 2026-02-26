
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EIUSEFI2 {

    static HashMap<String, Vertex> vertexs = new HashMap<>();
    static String tex;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        
        int n = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            String u = sc.next();
            String v = sc.next();
            vertexs.putIfAbsent(u, new Vertex(u));
            vertexs.putIfAbsent(v, new Vertex(v));
            vertexs.get(u).addLink(vertexs.get(v));
            vertexs.get(v).addLink(vertexs.get(u));
        }
        String root = sc.next();
        tex = sc.next();

        for(var val : vertexs.values()){
            val.list.sort((s1, s2)->{
                return s1.id.compareTo(s2.id);
            });
        }
         for(var val : vertexs.values()){
            if(val.list.size()>1){
                val.isFolder = true;
            }
        }
        dfs(vertexs.get(root));
        System.out.println(sb);
        
    }
    static void dfs(Vertex v){
        v.check = true;
        for(var ver : v.list){
            if(!ver.check){
                dfs(ver);
                if (ver.id.toLowerCase().contains(tex.toLowerCase()) &&  !ver.isFolder) {
                    v.count++;
                }
                if (ver.isFolder) {
                    v.count += ver.count;
                }
            }
        }
        if (v.count != 0) {
          sb.append(v.id).append(" ").append(v.count).append("\n");
        }
        
    }

    static class Vertex {
        int count = 0;
        String id;
        boolean check;
        boolean isFolder;
        ArrayList<Vertex> list = new ArrayList<>();

        public Vertex(String id) {
            this.id = id;
            this.check = false;
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
