import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EIUASSEMBLY {
    public static void main(String[] args) throws IOException{
        int testcase = sc.nextInt();
        for(int i=0; i<testcase; i++){
            int n = sc.nextInt();
            double money = sc.nextLong();
            TreeMap<Integer, Long> map = new TreeMap<>(Collections.reverseOrder());
            for(int j=0; j<n; j++){
                int key = sc.nextInt();
                map.put(key, map.getOrDefault(key, 0L)+sc.nextInt());
            }
            ArrayList<Integer> arr = new ArrayList<>(map.keySet());
            double max = arr.get(0);
            double sum = Assembly(map, money,max);
            if(sum!=money) {
                double left = 0;
                double right = Long.MAX_VALUE;
                double round = 1e-3;
                while(right-left>round){
                    max= (right+left)/2;
                    sum = Assembly(map, money,max);
                    if(Double.compare(sum, money)>0){
                        right=max;
                    }
                    else{
                        left=max;
                    }
                }
            }
            System.out.println((long)(max));
        }
    }
    static double total;
    static double Assembly(TreeMap<Integer, Long> map, double money, double max){
        total =0;
        map.forEach((key, val)->{
            total+=Math.max((max-key),0)*val;
        });
        return total;
    }
    static Reader sc = new Reader();
    static StringBuilder sb = new StringBuilder();

    static class Reader {
        private int BUFFER_SIZE = 1 << 16;
        private byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;
        private InputStream rd;

        public Reader() {
            this.rd = System.in;
        }

        private int read() throws IOException {
            if (bufferPointer == bytesRead) {
                bufferPointer = 0;
                bytesRead = rd.read(buffer, bufferPointer, BUFFER_SIZE);
                if (bytesRead == -1) {
                    return -1;
                }
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() throws IOException {
            int number = 0;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                number = number * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return negative ? -number : number;
        }

        public long nextLong() throws IOException {
            long number = 0L;
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean negative = (c == '-');
            if (negative) {
                c = read();
            }
            do {
                number = number * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return negative ? -number : number;
        }

        public String next() throws IOException {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            StringBuilder t = new StringBuilder();
            do {
                t.append((char) c);
                c = read();
            } while (c > ' ');
            return t.toString();
        }

        public String nextLine() throws IOException {
            int c = read();
            while (c == '\n' || c == '\r') {
                c = read();
            }
            StringBuilder t = new StringBuilder();
            while (c != '\n' && c != '\r' && c != -1) {
                t.append((char) c);
                c = read();
            }
            return t.toString();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            int c = read();
            while (c <= ' ') {
                c = read();
            }
            return (char) c;
        }
    }
}

