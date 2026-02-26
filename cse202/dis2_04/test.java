import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

 class App {
    static  HashMap <Integer, Integer> hm = new HashMap <>();
    static int index = 0;
    static int [] pre;

    public static void main(String[] args) {
       
     int n = sc.nextInt();
     pre = new int[n];
     for (int i = 0; i < n; i++) {
        pre[i] = sc.nextInt();
     }
     for (int i = 0; i < n; i++) {
        int key = sc.nextInt();
        hm.put(key, i);
     }
     print(0, n);
     System.out.println(sb);

     
    }
    static void print(int start, int end){
        if (start >= end) {
            return;
        }
        int node = pre[index ++];
        print(start, hm.get(node));
        print(hm.get(node) +1 ,end );
        sb.append(node).append(" ");
    }

    static void dfs(Vertex v) {
        
    }

    static class Vertex {

        int id;
        boolean visited;
        int day;
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