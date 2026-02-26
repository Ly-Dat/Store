
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EIUDAILYSALE {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        HashMap<Integer, Item> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int day = sc.nextInt();
            int id = sc.nextInt();
            if(!map.containsKey(day)){
                Item item = new Item(day);
                map.put(day, item);
            }
            map.get(day).addData(sc.nextInt(), sc.nextLong());
        }
        ArrayList<Item> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            return Integer.compare(p1.day, p2.day);
        });
        for(int i=list.get(0).day; i<=list.get(list.size()-1).day; i++){
            if(map.containsKey(i)){
                sb.append(map.get(i)).append("\n");
            }
            else{
                sb.append(i+" 0 0\n");
            }
        }
        System.out.println(sb);
    }
    static class Item{
        int day;
        long quantity;
        long money;
        public Item(int day) {
            this.day = day;
        }
        public void addData(int quantity, long money){
            this.quantity+=quantity;
            this.money+=money*quantity;
        }

        @Override
        public String toString() {
            return day + " " + quantity + " " + money;
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