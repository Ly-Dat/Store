import java.io.*;
import java.util.*;

class ArrayStack {
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Stack<Integer> arrayStack = new Stack<>(n);
        for (int i = 0; i < m; i++) {
            arrayStack.push(sc.nextInt());
        }
        for (int i = 0; i < k; i++) {
            String command = sc.next();
            switch (command) {
                case "count":
                    sb.append(arrayStack.count()).append("\n");
                    break;
                case "sum":
                    sb.append(arrayStack.sum()).append("\n");
                    break;
                case "average":
                    sb.append(arrayStack.average()).append("\n");
                    break;
                case "push":
                    int value = sc.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    sb.append(arrayStack.pop()).append("\n");
                    break;
                case "peek":
                    sb.append(arrayStack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    static class Stack<T extends Number> {
        private Object[] data;
        private int capacity;
        private int size;
        private double sum;

        public Stack(int capacity) {
            this.capacity = capacity;
            data = new Object[capacity];
            size = 0;
            sum = 0.0;
        }


        public int count() {
            return size;
        }
        
        public double sum() {
            return sum;
        }
        
        public double average() {
            if (size == 0) {
                return 0.0;
            }
            return sum / size;
        }
        
        @SuppressWarnings("unchecked")
        public void push(T item) {
            if (size == capacity) {
                sum -= ((T) data[0]).doubleValue();
                System.arraycopy(data, 1, data, 0, size - 1);
                data[size - 1] = item;
                sum += item.doubleValue();
            } else {
                data[size++] = item;
                sum += item.doubleValue();
            }
        }
        
        @SuppressWarnings("unchecked")
        public T pop() {
            if (size > 0) {
                T item = (T) data[size - 1];
                data[--size] = null;
                sum -= item.doubleValue();
                return item;
            } else {
                return null;
            }
        }
        
        @SuppressWarnings("unchecked")
        public T peek() {
            if (size > 0) {
                return (T) data[size - 1];
            } else {
                return null;
            }
        }
    }
static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}