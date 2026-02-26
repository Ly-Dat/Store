import java.io.*;
import java.util.*;


public class EIUGRDSA {
    public static void main(String[] args) {
        InputReader rd = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();

        int numberOfStudent = rd.nextInt();
        int numberOfProblems = rd.nextInt();
        int numberOfSubmission = rd.nextInt();
        HashMap<Integer, Student> students = new HashMap<>();
        for (int i = 0; i < numberOfStudent; i++) {
            
            Student s1 = new Student(rd.nextInt());
            students.put(s1.studentID, s1);
        }
        for (int i = 0; i < numberOfProblems; i++) {
            rd.next();
        }
        for (int i = 0; i < numberOfSubmission; i++) {
            int iD = rd.nextInt();
            students.get(iD).getScore(rd.nextInt(), rd.nextInt());
        }
        List<Integer> studentIDs = new ArrayList<>(students.keySet());
        Collections.sort(studentIDs);
        for (Integer ele : studentIDs) {
            sb.append(students.get(ele).studentID).append(" ").append(students.get(ele).getAverageGrade(numberOfProblems)).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {
        int studentID;
        int averageGrade = 0;
        HashMap<Integer, Integer> scores = new HashMap<>();

        public Student(int studentID) {
            this.studentID = studentID;
        }

        public void getScore(int subjectCode, int score) {
            if (scores.get(subjectCode) == null) {
                scores.put(subjectCode, score);
            } else if (scores.get(subjectCode) < score) {
                scores.put(subjectCode, score);
            }
        }

        public int getAverageGrade(int numberOfSubject) {
            for (int ele : scores.keySet()) {
                averageGrade += scores.get(ele);
            }
            return averageGrade /= numberOfSubject;
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