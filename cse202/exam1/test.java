import java.io.*;
import java.util.*;

class EIUWBT {
    static InputReader reader;
    static StringBuilder sb = new StringBuilder();
    static Vertex main = new Vertex(Integer.MAX_VALUE, 0);
    static long totalWeight;

    public static void main(String[] args) throws IOException {
        reader = new InputReader(System.in);
        int n = reader.nextInt() + 1;
        int size = n - 2;
        main.left = Long.MAX_VALUE;
        Vertex[] vertices = new Vertex[n];
        for (int i = 1; i < n; i++) {
            vertices[i] = new Vertex(i, reader.nextLong());
            totalWeight += vertices[i].weight;
        }

        while (size-- > 0) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            vertices[u].adjacentVertices.add(vertices[v]);
            vertices[v].adjacentVertices.add(vertices[u]);
        }

        dfs(vertices[2]);
        if (main.id == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(main.id + " " + Math.min(main.left, main.right) + " " + Math.max(main.right, main.left));
        }
    }

    static long dfs(Vertex v) {
        long t = v.weight;
        v.visited = true;
        if (v.adjacentVertices.size() == 2) {
            for (Vertex a : v.adjacentVertices) {
                if (!a.visited) {
                    v.left += dfs(a);
                    v.weight += a.weight;
                }

                v.right = totalWeight - v.left - t;
                if (v.get() < main.get()) {
                    main = v;
                } else if (v.get() == main.get() && v.id < main.id) {
                    main = v;
                }
            }
        } else {
            for (Vertex a : v.adjacentVertices) {
                if (!a.visited) {
                    v.weight += dfs(a);
                }
            }
        }

        return v.weight;
    }

    static class Vertex {
        int id;
        boolean visited;
        List<Vertex> adjacentVertices = new ArrayList<>();
        long left;
        long right;
        long weight;

        public Vertex(int id, long weight) {
            this.id = id;
            this.weight = weight;
        }

        public long get() {
            return Math.abs(left - right);
        }
    }


    static class InputReader {
        private byte[] inbuf = new byte[2 << 23];
        public int lenbuf = 0, ptrbuf = 0;
        public InputStream is;

        public InputReader(InputStream stream) throws IOException {

            inbuf = new byte[2 << 23];
            lenbuf = 0;
            ptrbuf = 0;
            is = System.in;
            lenbuf = is.read(inbuf);
        }

        public InputReader(FileInputStream stream) throws IOException {
            inbuf = new byte[2 << 23];
            lenbuf = 0;
            ptrbuf = 0;
            is = stream;
            lenbuf = is.read(inbuf);
        }

        public boolean hasNext() throws IOException {
            if (skip() >= 0) {
                ptrbuf--;
                return true;
            }
            return false;
        }

        public String nextLine() throws IOException {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b) && b != ' ') { // when nextLine, ()
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b
                                        // != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        private int readByte() {
            if (lenbuf == -1)
                throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0)
                    return -1;
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private double nextDouble() {
            return Double.parseDouble(next());
        }

        public Character nextChar() {
            return skip() >= 0 ? (char) skip() : null;
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }

}