import java.io.IOException;
import java.io.InputStream;
import java.lang.*;
import java.util.*;

public class EITASKDIS {
    public static void main(String[] args) throws java.lang.Exception{
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<m; i++){
            arr.add(sc.nextInt());
        }
        arr.sort((p1, p2)->p2-p1);
        PriorityQueue<Person> persons = new PriorityQueue<>((p1, p2)->{
            int cmp = Integer.compare(p1.loaded, p2.loaded);
            if(cmp==0){
                return Integer.compare(p1.index, p2.index);
            }
            return cmp;
        });
        for(int i=0; i<n; i++){
            persons.add(new Person(i));
        }
        for(int i=0; i<m; i++){
            Person leastPerson = persons.poll();
            leastPerson.addLoaded(arr.get(i));
            persons.add(leastPerson);
        }
        persons.stream().sorted((p1,p2)->{
            return Integer.compare(p1.index, p2.index);
        }).forEachOrdered(p->sb.append(p.loaded).append(" "));
        System.out.println(sb);
    }
    static class Person{
        int index;
        int loaded=0;

        public Person(int index) {
            this.index = index;
        }

        public void addLoaded(int a){
            this.loaded+=a;
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
