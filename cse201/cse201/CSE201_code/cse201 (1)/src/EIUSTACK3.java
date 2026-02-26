import java.util.*;
import java.io.*;

 class EIUSTACK3 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] arg) {
        int capacity = sc.nextInt();
        int numberOfInitialE = sc.nextInt();
        int numberOfCommand = sc.nextInt();

        ArrayStack<Integer> stack = new ArrayStack<Integer>(capacity);

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

    static class ArrayStack<T extends Number> {
        // Your code here
        Object[] data;
        int lastIndex = 0;
        private int count = 0;
        private long sum = 0;

        public ArrayStack(int capacity) {
            data = new Object[capacity];
        }

        public int count() {
            return this.count;
        }

        public double sum() {
            // Your code here
            // T number;
            // number.doubleValue();
            return this.sum;
        }

        public double average() {
            // Your code here
            return (double) this.sum / this.count;
        }

        /**
         * @description: When stack is full => override the earliest added item
         */
        public void push(T item) {
            if (data[lastIndex] != null)
                this.sum -= ((Number) data[lastIndex]).longValue();
            else
                this.count++;
            this.sum += ((Number) item).longValue();
            data[lastIndex++] = item;
            if (lastIndex == data.length)
                lastIndex = 0;

        }

        /**
         * @return: return and remove top item, or null when stack is empty
         */
        @SuppressWarnings("unchecked")
        public  T pop() {
            // Your code here
            T number = null;
            if (lastIndex != 0){
                number = (T)data[lastIndex -1];
                data[lastIndex-- - 1] = null;
            }else{
                int lastIndexOfArr = data.length - 1;
                number = (T)data[lastIndexOfArr];
                data[lastIndexOfArr] = null;
                lastIndex = lastIndexOfArr;
            }
            if (number != null){
                sum -= ((Number) number).longValue();
                count--;
            }
            return number;
        }

        /**
         * @return: return top item, or null when stack is empty
         */
        @SuppressWarnings("unchecked")
        public T peek() {
            // Sample return (T) data[lastIndex - 1];
            // Your code here
            return count == 0 ? null : lastIndex == 0 ? (T) data[data.length - 1] : (T) data[lastIndex - 1];
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
