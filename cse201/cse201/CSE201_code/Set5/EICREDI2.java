import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EICREDI2 {


    public static void main(String[] args) {
        InputReader rd = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            String name = rd.next();
            int finisedCourse = rd.nextInt();
            Student s1 = new Student(name, finisedCourse);
            for (int j = 0; j < finisedCourse; j++) {
                s1.getScoreList(j, rd.nextInt());
            }
            s1.getAverage();
            sb.append(s1.toString());
        }
        System.out.println(sb);
    }

    static class Student {
        String name;
        int finishedCourse;
        int[] listOfCourse;
        int average = 0;
        int count = 0;
        StringBuilder passed = new StringBuilder();

        public Student(String name, int finishedCourse) {
            this.name = name;
            this.finishedCourse = finishedCourse;
            listOfCourse = new int[finishedCourse];
        }

        public void getScoreList(int index, int score) {
            listOfCourse[index] = score;
        }

        public void getAverage() {
            for (int i = 0; i < listOfCourse.length; i++) {
                if (listOfCourse[i] >= 50) {
                    average += listOfCourse[i];
                    count++;
                    passed.append(listOfCourse[i]).append(" ");
                }
            }
            if (count > 0)
                average /= count;
            else {
                average = 0;
            }
        }

        @Override
        public String toString() {
            if (count > 0)
                return name + " " + passed + average + "\n";
            else
                return name + " " + average + "\n";
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