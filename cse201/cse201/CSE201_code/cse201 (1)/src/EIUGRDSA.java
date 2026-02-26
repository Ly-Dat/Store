import java.util.*;
import java.io.*;

public class EIUGRDSA {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Student> mapStudents;

    public static void main(String[] args) {
        var nOfStudents = sc.nextInt();
        var nCourses = sc.nextInt();
        var nOfSubmissions = sc.nextInt();
        mapStudents = new TreeMap<Integer, Student>();

        for (int i = 0; i < nOfStudents; i++) {
            var id = sc.nextInt();
            mapStudents.put(id, new Student(id, nCourses));
        }

        for (int i = 0; i < nCourses; i++) {
            var a = sc.nextInt();
        }

        for (int i = 0; i < nOfSubmissions; i++) {
            var id = sc.nextInt();
            var code = sc.nextInt();
            var grade = sc.nextInt();
            Student student = mapStudents.get(id);
            var oldGrade = student.mapGrades.get(code);
            if (oldGrade == null) {
                student.mapGrades.put(code, grade);
            } else if (oldGrade.intValue() < grade) {
                student.mapGrades.replace(code, grade);
            }
        }

        mapStudents.forEach((k, v) -> {
            v.calAverageGrade();
            sb.append(v).append("\n");
        });
        System.out.println(sb);
    }

    static class Student {
        int id;
        int nCourses;
        long totalGrade;
        long averageGrade;
        Map<Integer, Integer> mapGrades;

        public Student(int id, int nCourses) {

            this.id = id;
            this.nCourses = nCourses;
            this.mapGrades = new HashMap<>(nCourses);
        }

        public void calAverageGrade() {

            mapGrades.forEach((k, v) -> {
                this.totalGrade += v.intValue();
            });
            averageGrade = totalGrade / nCourses;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.id).append(" ").append(this.averageGrade);
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
