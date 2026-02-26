import java.util.*;
import java.io.*;

public class EISTULI2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        var nStudents = sc.nextInt();
        var kTH = sc.nextInt();
        var listStudents = new ArrayList<Student>(nStudents);
        for (int i = 0; i < nStudents; i++) {
            var id = sc.nextInt();
            var name = sc.next();
            var nGrades = sc.nextInt();
            var totalGrade = 0;
            var nPassedCourses = 0;
            for (int j = 0; j < nGrades; j++) {
                var grade = sc.nextInt();
                if (grade > 49) {
                    totalGrade += grade;
                    nPassedCourses += 1;
                }
            }
            listStudents.add(new Student(id, name,
                    nPassedCourses == 0 ? 0 : Math.round((float) totalGrade / nPassedCourses), nPassedCourses << 2));
        }

        listStudents.sort((a, b) -> {
            var compare = Integer.compare(b.averageGrade, a.averageGrade);
            return compare != 0 ? compare : Integer.compare(b.nPassedCredits, a.nPassedCredits);
        });

        for (int i = 0; i < kTH; i++) {
            sb.append(listStudents.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {

        long id;
        String name;
        int nPassedCredits;
        int averageGrade;

        public Student(long id, String name, int averageGrade, int nPassedCredits) {

            this.id = id;
            this.name = name;
            this.averageGrade = averageGrade;
            this.nPassedCredits = nPassedCredits;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.id).append(" ").append(this.name).append(" ");
            if (this.nPassedCredits != 0)
                sb.append(this.averageGrade).append(" ").append(this.nPassedCredits);
            else
                sb.append("0");
            return sb.toString();
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
