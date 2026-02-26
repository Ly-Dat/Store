import java.util.*;
import java.io.*;

public class EI2122Q1ADAM1 {
    static InputReader sc = new InputReader(System.in);

    public static void main(String[] args) {
        var length = sc.nextInt();
        var x = sc.nextDouble();
        NumberObj[] arrNums = new NumberObj[length];
        setArr(arrNums);
        Arrays.sort(arrNums, new Comparator<NumberObj>() {

            @Override
            public int compare(NumberObj o1, NumberObj o2) {
                var cmp = Double.compare(o1.value, o2.value);
                if (cmp == 0)
                    return Integer.compare(o1.index, o2.index);
                return cmp;
            }
        });
        int temp2 = arrNums.length - 1;

        var numberObjComparator = new Comparator<NumberObj>() {

            @Override
            public int compare(NumberObj a, NumberObj b) {
                return Double.compare(a.value, b.value);
            }
        };

        long count = 0;
        for (int i = 0; i < temp2; i++) {
            NumberObj temp = new NumberObj(arrNums[i].index, arrNums[i].value + x + 0.5);
            int upperBound = ~Arrays.binarySearch(arrNums, i + 1, arrNums.length, temp, numberObjComparator);
            temp.value -= 1.0;
            int lowerBound = ~Arrays.binarySearch(arrNums, i + 1, arrNums.length, temp, numberObjComparator);
            for (int j2 = lowerBound; j2 < upperBound; j2++) {
                if (temp.index < arrNums[j2].index) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

    private static void setArr(NumberObj[] arrNumbers) {
        for (int i = 0; i < arrNumbers.length; i++) {
            arrNumbers[i] = new NumberObj(i, sc.nextDouble());
        }
    }

    static class NumberObj {
        int index;
        double value;

        public NumberObj(int index, double value) {
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
