import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

class EIUATTEND1 {
    static int max=0;
    static int sum;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<String, student> map = new HashMap<>();
        
        for(int i=0; i<M; i++){
            String time = sc.next();
            String id = sc.next();
            if(!map.containsKey(id)){
                student st = new student(id);
                map.put(id, st);
            }
            map.get(id).add(time, sc.next(), sc.nextInt());
        }
        ArrayList<student> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            return p1.id.compareTo(p2.id);
        });
        list.forEach(p->sb.append(p).append("\n"));
        System.out.println(sb);

    }
    static class student{
        String id;
        HashMap<String, Integer> subject;
        ArrayList<String> list;
        public student(String id) {
            this.id = id;
            this.subject = new HashMap<>();
            this.list = new ArrayList<>();
        }
        public void add(String time, String code, int check){
            if(!list.contains(time)){
                subject.put(code, subject.getOrDefault(code, 0)+check);
                list.add(time);
            }
            if(list.size()>max){
                max=list.size();
            }
        }
        public int countPresent(){
            sum = 0;
            subject.forEach((key, val)->sum+=val);
            return sum;
        }
        @Override
        public String toString() {
            int a = countPresent();
            return  id + " " + (max-a) + " " + a;
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
