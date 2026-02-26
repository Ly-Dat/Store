
import java.io.IOException;
import java.io.InputStream;

public class EIUMEDARRAY4 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
            int lenght = sc.nextInt();
            long A = sc.nextLong();
            long P = sc.nextLong();
            int vt = sc.nextInt();
            long[] arr = new long[lenght];
            arr[0] = A * A % P;
            for (int i = 1; i < lenght; i++) {
                arr[i] = arr[i - 1] * A % P;
            }
            long result = quickSort(arr, 0, lenght - 1, vt);
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }

    static long quickSort(long[] arr, int left, int right, int vt) {
        int i = divide(arr, left, right);
        if (i > vt-1) {
            return quickSort(arr, left, i - 1, vt);
        }
        if (i < vt-1) {
            return quickSort(arr, i+1, right, vt);
        }
        return arr[i];

    }

    static int divide(long[] arr, int left, int right) {
        long pivot = arr[right];
        int i = left-1;
        for(int j=left; j<right; j++){
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, right);
        return i+1;
    }

    static void swap(long arr[], int i, int j){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
