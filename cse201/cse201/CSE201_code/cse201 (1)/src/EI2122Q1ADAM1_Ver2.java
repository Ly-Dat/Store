import java.util.*;
import java.io.*;

public class EI2122Q1ADAM1_Ver2 {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        var length = sc.nextInt();
        var x = sc.nextLong();
        long[] arrNums = new long[length];
        setArr(arrNums);
        long count = 0;
        for (int i = 0; i < arrNums.length; i++) {
            long plus = arrNums[i] + x;
            for (int j = i + 1; j < arrNums.length; j++) {
                if (plus == arrNums[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void setArr(long[] arrNumbers) {
        for (int i = 0; i < arrNumbers.length; i++) {
            arrNumbers[i] = sc.nextLong();
        }
    }

    static class NumberObj {
        int index;
        long value;

        public NumberObj(int index, long value) {
            this.index = index;
            this.value = value;
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
