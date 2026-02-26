import java.util.*;
import java.io.*;

public class EIUGRDSA2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int nStudents = sc.nextInt();
        int nExersises = sc.nextInt();
        int nSubmissions = sc.nextInt();

        var mapStudents = new HashMap<Integer, Student>();
        for (int i = 0; i < nStudents; i++) {
            int id = sc.nextInt();
            mapStudents.put(id, new Student(id));
        }

        var setExercises = new HashSet<Integer>();
        for (int i = 0; i < nExersises; i++) {
            setExercises.add(sc.nextInt());
        }

        for (int i = 0; i < nSubmissions; i++) {

            var id = sc.nextInt();
            var exerciseCode = sc.nextInt();
            var grade = sc.nextInt();
            if (setExercises.contains(exerciseCode)) {

                Student student = mapStudents.get(id);

                if (!student.mapGrades.containsKey(exerciseCode)) {
                    student.totalGrade += grade;
                    student.mapGrades.put(exerciseCode, grade);
                } else {
                    int gradeInMap = student.mapGrades.get(exerciseCode);
                    if (gradeInMap < grade) {
                        student.totalGrade += grade - gradeInMap;
                        student.mapGrades.put(exerciseCode, grade);
                    }
                }

                student.nValidSubmissions++;
            }

        }
        var listStudents = new ArrayList<Student>(mapStudents.size());
        for (Map.Entry<Integer, Student> student : mapStudents.entrySet()) {
            student.getValue().calAverageGrade();
            listStudents.add(student.getValue());
        }

        listStudents.sort((a, b) -> {
            var compare = Double.compare(b.averageGrade, a.averageGrade);
            if (compare == 0)
                compare = a.nValidSubmissions - b.nValidSubmissions;
            return compare == 0 ? a.id - b.id : compare;
        });

        for (Student student : listStudents) {
            sb.append(student).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {
        int id;
        long totalGrade;
        double averageGrade;
        int nValidSubmissions;
        Map<Integer, Integer> mapGrades;

        public Student(int id) {

            this.id = id;
            this.mapGrades = new HashMap<>();
        }

        public void calAverageGrade() {

            if (mapGrades.size() > 0)
                this.averageGrade = (double) this.totalGrade / (double) mapGrades.size();
        }

        @SuppressWarnings("static-access")
        @Override
        public String toString() {
            return new String().join(" ", Integer.toString(id), Integer.toString((int)Math.floor(averageGrade)),
                    Integer.toString(nValidSubmissions));
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
