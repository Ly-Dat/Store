import java.util.*;
import java.io.*;

public class EIUSLS {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nStudents = sc.nextInt();
        var listStudents = new ArrayList<Student>(nStudents);
       
        for (int i = 0; i < nStudents; i++) {
            listStudents.add(new Student(sc.next(), sc.nextInt()));
        }
        listStudents.sort((a, b) -> {
            return Double.compare(b.averageGrade, a.averageGrade);
        });

        for (int i = 0; i < listStudents.size() && i < 2; i++) {
            sb.append(listStudents.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {
        String name;
        int nOfSubjects;
        double averageGrade;

        public Student(String name, int length) {
            this.name = name;
            calAverageGrade(length);
        }

        private void calAverageGrade(int length) {
            long totalGrade = 0;
            for (int i = 0; i < length; i++) {
                totalGrade += sc.nextInt();
                this.nOfSubjects++;
            }
            this.averageGrade = (double) totalGrade / this.nOfSubjects;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

}
