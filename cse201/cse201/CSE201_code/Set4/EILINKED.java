import java.io.*;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;


class EILINKED {
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        InputReader sc = new InputReader(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            String command = sc.next();
            switch (command) {
                case "firstIndexOf":
                    sb.append(firstIndexOf(sc.nextInt())).append("\n");
                    break;
                case "lastIndexOf":
                    sb.append(lastIndexOf(sc.nextInt())).append("\n");
                    break;
                case "sum":
                    sb.append(sum()).append("\n");
                    break;
                case "average":
                    sb.append(average()).append("\n");
                    break;
                case "getAt":
                    sb.append(getAt(sc.nextInt())).append("\n");
                    break;
                case "removeFirst":
                    removeFirst(sc.nextInt());
                    break;
                case "removeAt":
                    removeAt(sc.nextInt());
                    break;
                case "insertAt":
                    insertAt(sc.nextInt(), sc.nextInt());
                    break;
            }
        }
        System.out.println(sb);
    }

    static int firstIndexOf(int number) {
        if (list.contains(number))
            return list.indexOf(number);
        return -1;
    }

    static int lastIndexOf(int number) {
        if (list.contains(number))
            return list.lastIndexOf(number);
        return -1;
    }

    static double sum() {
        if (list.isEmpty())
            return 0;
        double sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    static double average() {
        if (list.isEmpty())
            return 0;
        return sum() / list.size();
    }

    static Integer getAt(int index) {
        if (index >= 0 && index < list.size())
            return list.get(index);
        else return null;
    }

    static void removeFirst(int number) {
        list.removeFirstOccurrence(number);
    }

    static void removeAt(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        }
    }

    static void insertAt(int index, int number) {
        list.add(index, number);
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