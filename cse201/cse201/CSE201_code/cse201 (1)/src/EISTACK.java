import java.util.*;
import java.io.*;

public class EISTACK {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int capacity = sc.nextInt();
        int numberOfInitialE = sc.nextInt();
        int numberOfCommand = sc.nextInt();

        ArrayBasedStack<Integer> stack = new ArrayBasedStack<Integer>(capacity);

        for (int i = 0; i < numberOfInitialE; i++) {
            stack.push(sc.nextInt());
        }

        for (int i = 0; i < numberOfCommand; i++) {
            String command = sc.next();
            switch (command) {
                case "count":
                    sb.append(stack.count()).append("\n");
                    break;
                case "sum":
                    sb.append(stack.sum()).append("\n");
                    break;
                case "average":
                    sb.append(stack.average()).append("\n");
                    break;
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                default:
                    sb.append(stack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }

    static class ArrayBasedStack<T extends Number> {

        // Your code here
        private Object[] data;
        private int lastIndex = -1;
        private long sum = 0;

        public ArrayBasedStack(int capacity) {
            data = new Object[capacity];
        }

        public int count() {
            return lastIndex + 1;
        }

        public double sum() {
            // Your code here
            // T number;
            // number.doubleValue();
            return sum;
        }

        public double average() {
            // Your code here
            return count() == 0 ? 0.0 : (double)sum / count();
        }

        /**
         * @description: add item when stack is not full
         */
        public void push(T item) {
            // Sample: data[lastIndex++] = item;
            // Your code here
            if (count() < data.length) {
                data[++lastIndex] = item;
                sum += ((Number)item).longValue();
            }
        }

        /**
         * @return: return and remove top item, or null when stack is empty
         */
        @SuppressWarnings("unchecked")
        public T pop() {
            if (!isEmpty()) {
                T temp = (T) data[lastIndex];
                data[lastIndex--] = null;
                sum -=((Number)temp).longValue();
                return temp;
            }
            return null;
        }

        /**
         * @return: return top item, or null when stack is empty
         */
        @SuppressWarnings("unchecked")
        public T peek() {
            // Sample return (T) data[lastIndex - 1];
            // Your code here
            return (!isEmpty()) ? (T) data[lastIndex] : null;
        }

        private boolean isEmpty() {
            return (lastIndex < 0) ? true : false;
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
