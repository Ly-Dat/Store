
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EIFACEBOOK {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        Vertex[] list = new Vertex[N];
        for (int i = 0; i < N; i++) {
            list[i] = new Vertex(i, sc.next());
        }
        for (int j = 0; j < M; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list[u - 1].addLink(list[v - 1]);
            list[v - 1].addLink(list[u - 1]);
        }
        for (Vertex ver : list) {
            sb.append(ver.getCount()).append(" ");
        }
        System.out.println(sb);
    }

    static class Vertex {
        int id;
        String gender;
        List<Vertex> listFriend = new ArrayList<>();

        public Vertex(int id, String gender) {
            this.gender = gender;
        }

        public void addLink(Vertex v) {
            if (!listFriend.contains(v)) {
                listFriend.add(v);
            }
        }

        public int getCount() {
            int count = 0;
            for (Vertex v : listFriend) {
                if (!v.gender.equals(this.gender)) {
                    count++;
                }
            }
            return count;
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
