
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class EILOCALA {
    static int[] longPath = new int[2];
    public static void main(String[] args) {
        int n = sc.nextInt();
        List<List<Edge>> list = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list.get(u).add(new Edge(v, w));
            list.get(v).add(new Edge(u, w));
        }
        int[] fbfs = bfs(0, n, list);
        int fVertex = fbfs[0];

        int[] sbfs = bfs(fVertex, n, list);
        int sVertex = sbfs[0];
        int maxDist = sbfs[1];

        int result = Math.min(fVertex, sVertex);

        System.out.println(result + " " + maxDist);
    }
    static int[] bfs(int start, int n, List<List<Edge>> list){
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[start] = 0;
        queue.add(start);
        int farthestVertex = start;
        int maxDist = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for(Edge edge : list.get(vertex)){
                if(dist[edge.end] == -1){
                    dist[edge.end] = dist[vertex] + edge.len;
                    queue.add(edge.end);
                    if (dist[edge.end] > maxDist) {
                        maxDist = dist[edge.end];
                        farthestVertex = edge.end;
                    }
                }
            }
        }
        return new int[]{farthestVertex, maxDist};
    }
    static class Edge{
        int end;
        int len;
        public Edge(int end, int len) {
            this.end = end;
            this.len = len;
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
