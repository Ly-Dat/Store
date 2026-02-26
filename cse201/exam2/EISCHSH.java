import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class EISCHSH {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> arr = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0; i<n; i++){
            Student st = new Student(sc.nextLong(), sc.next());
            int lenght = sc.nextInt();
            for(int j=0; j<lenght; j++){
                st.addGrade(sc.nextInt());
            }
            arr.add(st);
        }
        arr.sort((p1,p2)->{
            int a = Double.compare(p2.getAvg(), p1.getAvg());
            if(a!=0){
                return a;
            }
            return Long.compare(p1.id, p2.id);
        });
        int rank=1;
        sb.append(rank+" ").append(arr.get(0).toString()).append("\n");
        for(int i=1; i<n; i++){
            if(Double.compare(arr.get(i).getAvg(), arr.get(i-1).getAvg())!=0){
                rank= i+1;
            }
            if(rank<=k){
                sb.append(rank+" ").append(arr.get(i).toString()).append("\n");
            }
            else{
                break;
            }
        }
        System.out.println(sb);
    }
    static class Student{
        long id; 
        String name;
        double sum=0;
        int count=0;
        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                sum+=grade;
                count++;
            }
        }
        public double getAvg(){
            if(count==0){
                return 0;
            }
            return sum/count;
        }
        @Override
        public String toString() {
            return id + " "+name+" "+Math.round(getAvg());
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
