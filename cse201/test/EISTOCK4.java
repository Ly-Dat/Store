import java.util.*;
import java.util.LinkedList;
import java.io.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        TreeMap<Integer, Queue<Product>> map = new TreeMap<>();
        HashMap<Integer, Integer> sumNum = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String check = sc.next();
            int id = sc.nextInt();
            int num = sc.nextInt();
            long money = sc.nextLong();
            int time = sc.nextInt();

            if (check.equals("+")) {
                if (!map.containsKey(id)) {
                    map.put(id, new LinkedList<>());
                }
                map.get(id).add(new Product(money, num, time));
                sumNum.put(id, sumNum.getOrDefault(id, 0) + num);
            } else {
                if (map.containsKey(id) && num <= sumNum.getOrDefault(id, 0)) {
                    Queue<Product> queue = map.get(id);
                    while (num > 0 && !queue.isEmpty()) {
                        Product product = queue.peek();
                        int available = product.num;

                        if (num >= available) {
                            num -= available;
                            queue.poll(); 
                            sumNum.put(id, sumNum.get(id) - available);
                        } else {
                            product.num -= num; 
                            sumNum.put(id, sumNum.get(id) - num);
                            num = 0;
                        }
                    }
                }
            }
        }

        map.forEach((key, val) -> {
            if (!val.isEmpty()) {

                for (Product a : val) {
                    int oldTime = a.time;
                    sb.append(key).append(" ").append(a.num*a.money).append(" ").append(oldTime).append("\n");
                    // sumMoney += a.money * a.num;
                    // sum += a.num;
                }

                
            }
        });

        System.out.println(sb);
    }

    static class Product {
        int num;
        long money;
        int time;

        public Product(long money, int num, int time) {
            this.money = money;
            this.num = num;
            this.time = time;
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