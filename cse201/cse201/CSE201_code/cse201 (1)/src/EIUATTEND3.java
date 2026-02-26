import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIUATTEND3 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int classSizes = sc.nextInt();
        int attendanceSizes = sc.nextInt();

        Map<Integer, Classroom> classMap = new TreeMap<>();

        while (classSizes-- > 0) {
            String studentID = sc.next();
            int student_numbered_id = Integer.parseInt(studentID);
            String classID = sc.next();
            int class_numbered_id = Integer.parseInt(classID);

            if (!classMap.containsKey(class_numbered_id))
                classMap.put(class_numbered_id, new Classroom(classID, class_numbered_id));

            classMap.get(class_numbered_id).studentMap.put(student_numbered_id,
                    new Student(studentID, student_numbered_id));
        }

        while (attendanceSizes-- > 0) {
            long startingTime = sc.nextLong();
            int studentID = sc.nextInt();
            int classID = sc.nextInt();
            int check_in = sc.nextInt();
            Classroom clrm = classMap.get(classID);
            if (clrm.studentMap.containsKey(studentID)) {
                if (!clrm.lessonSet.contains(startingTime))
                    clrm.lessonSet.add(startingTime);
                if (check_in == 1)
                    clrm.studentMap.get(studentID).totalAttendances++;
            }
        }

        for (Classroom e : classMap.values()) {
            sb.append(e.toString());
        }
        System.out.println(sb);
    }

    static class Classroom {
        int numbered_id;
        String id;
        Set<Long> lessonSet = new HashSet<>();
        Map<Integer, Student> studentMap = new TreeMap<>();

        public Classroom(String id, int class_numbered_id) {
            this.id = id;
            this.numbered_id = class_numbered_id;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(id).append("\n");
            for (Student student : studentMap.values()) {
                student.calculateTotalAbsences(lessonSet.size());
                sb.append(student.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    static class Student {
        int numbered_id;
        String id;
        int totalAttendances;
        int totalAbsences;

        public Student(String id, int numbered_id) {
            this.id = id;
            this.numbered_id = numbered_id;
        }

        public void calculateTotalAbsences(int totalLessons) {
            totalAbsences = totalLessons - totalAttendances;
        }

        @SuppressWarnings("static-access")
        @Override
        public String toString() {
            return String.join(" ", id, Integer.toString(totalAbsences),
                    Integer.toString(totalAttendances));
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
