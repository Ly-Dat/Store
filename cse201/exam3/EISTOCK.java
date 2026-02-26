import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EISTOCK {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        HashMap<Integer, product> map = new HashMap<>();
        
        for(int i=0; i<N; i++){
            String check = sc.next();
            int id = sc.nextInt();
            if(!map.containsKey(id)){
                product pr = new product(id);
                map.put(id, pr);
            }
            map.get(id).addData(check, sc.nextInt(), sc.nextLong());
        }
        ArrayList<product> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->p1.id - p2.id);
        list.forEach(p->{
            if(p.moneyI !=0 || p.moneyO!=0){
                sb.append(p).append("\n");
            }
        });
        System.out.println(sb);

    }
    static class product{
        int id;
        long numI=0;
        long moneyI=0;
        long moneyO=0;
        public product(int id) {
            this.id = id;
        }
        public void addData(String check, int num, long price){
            if(check.equals("+")){
                numI+=num;
                moneyI+=num*price;
            }
            else if(numI>=num){
                numI-=num;
                moneyO+=num*price;
            }
        }
        @Override
        public String toString() {
            return id + " " + moneyI + " " + moneyO;
        }
        
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
