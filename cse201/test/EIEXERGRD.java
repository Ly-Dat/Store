import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class EIEXERGRD {
    static HashMap<Integer, Integer> exercise;
    static int max=0;
    static double sum;
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int P = sc.nextInt();
        int M = sc.nextInt();
        exercise = new HashMap<>();
        HashMap<Integer, student> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int id = sc.nextInt();
            student st = new student(id);
            map.put(id, st);
        }
        for(int i=0; i<P; i++){
            int code = sc.nextInt();
            int weight = sc.nextInt();
            exercise.put(code, weight);
            max+=weight;
        }
        for(int i=0; i<M; i++){
            int id = sc.nextInt();
            int code = sc.nextInt();
            int grade = sc.nextInt();
            if(map.containsKey(id) && exercise.containsKey(code)){
                map.get(id).addGrade(code, grade);
            }
        }
        ArrayList<student> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(p->sb.append(p).append("\n"));
        System.out.println(sb);
    }
    static class student{
        int id;
        HashMap<Integer, Integer> subject;
        public student(int id) {
            this.id = id;
            this.subject = new HashMap<>();
        }
        public void addGrade(int code, int grade){
            if(!subject.containsKey(code)){
                subject.put(code, 0);
            }
            subject.put(code, Math.max(subject.get(code),grade));
        }
        public double avr(){
            sum = 0;
            subject.forEach((key,val)->{
                sum+=val*exercise.get(key);
            });
            return sum/max;
        }
        @Override
        public String toString() {
            return id + " " + (int)avr();
        }
        
        
    }
static Reader sc = new Reader();

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
