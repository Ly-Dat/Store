import java.util.*;
import java.io.*;

 class EISCH2 {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nStudents = sc.nextInt();
        var nScholarshipA = nStudents / 12;
        var nscholarshipB = nStudents / 3;
        var nscholarshipC = nStudents / 2;
        var listStudent = new ArrayList<Student>(nStudents);
        for (int i = 0; i < nStudents; i++) {
            var name = sc.next();
            var nSubjects = sc.nextInt();
            var totalGrade = getTotalGrade(nSubjects);
            listStudent.add(new Student(name, (double) totalGrade / nSubjects));
        }

        listStudent.sort((a, b) -> {
            var compare = Double.compare(b.gpa, a.gpa);
            return compare == 0 ? a.name.compareTo(b.name) : compare;
        });

    var count = 0;
        double gpa = listStudent.get(nScholarshipA).gpa;
        for (int i = 0; i < nScholarshipA; i++) {
            Student student = listStudent.get(i);
            if (Double.compare(student.gpa, gpa) != 0) {
                student.scholarshipType = "A";
                sb.append(student).append("\n");
                count++;
            }
        }

        gpa = listStudent.get(nscholarshipB).gpa;
        for (int i = count; i < nscholarshipB; i++) {
            Student student = listStudent.get(i);
            if (Double.compare(student.gpa, gpa) != 0) {
                student.scholarshipType = "B";
                sb.append(student).append("\n");
                count++;
            }
        }

        gpa = listStudent.get(nscholarshipC).gpa;
        for (int i = count; i < nscholarshipC; i++) {
            Student student = listStudent.get(i);
            if (Double.compare(student.gpa, gpa) != 0) {
                student.scholarshipType = "C";
                sb.append(student).append("\n");
                count++;
            }
        }
        System.out.println(sb);
    }

    private static int getTotalGrade(int nSubjects) {
        int totalgrade = 0;
        for (int i = 0; i < nSubjects; i++) {
            totalgrade += sc.nextInt();
        }
        return totalgrade;
    }

    static class Student {
        String name;
        double gpa;
        String scholarshipType;
        double roundedGpa;

        public Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
            calRoundedGPA();
        }

        public void calRoundedGPA() {
            roundedGpa = Math.round(this.gpa * 100) / 100.0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(this.name).append(" ").append(this.roundedGpa).append(" ")
                    .append(this.scholarshipType)
                    .toString();
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
