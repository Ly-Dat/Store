
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class EIUGRDSA2 {

    static  int numProblem;
    public static void main(String[] args) throws IOException{

        StringBuilder sb = new StringBuilder();
        int numStudent = sc.nextInt();
        numProblem = sc.nextInt();
        int numSubmit = sc.nextInt();
        HashMap<Integer, Student> map = new HashMap<>();
        
        for(int i=0; i<numStudent; i++){
            int id = sc.nextInt();
            Student std = new Student(id);
            map.putIfAbsent(id, std);
        }

        ArrayList<Integer> arrCode = new ArrayList<>();
        for(int j=0; j<numProblem; j++){
            arrCode.add(sc.nextInt());
        }
       
        for(int k=0; k<numSubmit; k++){
            int id = sc.nextInt();
            int code = sc.nextInt();
            int score = sc.nextInt();
            if(map.containsKey(id) && arrCode.contains(code)){
                var a = map.get(id);
                a.addScore(code, score);
                
            }
        }
        var list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            int a = Integer.compare(p2.avg(), p1.avg());
            int b = Integer.compare(p1.count, p2.count);
            if(a!=0){
                return a; 
            }
            if(b!=0){
                return b;
            }
            return Integer.compare(p1.id, p2.id);
        });
        for (Student student : list) {
            sb.append(student).append("\n");
        }
        System.out.println(sb);


    }
    static class Student{
        int count = 0;
        int id;
        Map<Integer, Integer> scores = new HashMap<>();
        public Student(int id) {
            this.id = id;
        }
        public void addScore(int code, int score){
            count++;
            if(scores.get(code)==null){
                scores.put(code, score);
            }
            else{
                int max = Math.max(scores.get(code), score);
                scores.put(code, max);
            }
            
        }
        public int avg(){
            int avg=0;
            for(var key : scores.keySet()){
                avg+=scores.get(key);
            }
            avg /= numProblem;
            return avg;
        }

        @Override
        public String toString() {
           return  id +" "+ avg()+" "+count;
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

