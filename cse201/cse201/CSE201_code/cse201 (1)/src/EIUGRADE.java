import java.util.*;
import java.io.*;

public class EIUGRADE {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var numberOfRecords = sc.nextInt();
        var mapStudents = new HashMap<Long, Student>();
        for (int i = 0; i < numberOfRecords; i++) {
            var id = sc.nextLong();
            var subjectCode = sc.nextLong();
            var grade = sc.nextDouble();

            var student = mapStudents.get(id);
            if (student == null) {
                student = new Student(id);
                mapStudents.put(id, student);
            }
            student.totalGrade += grade;
            student.totalSubjects++;
        }
        var listStudents = new ArrayList<Student>(mapStudents.values());
        for (Student student : listStudents) {
            student.calGpa();
            ;
        }
        listStudents.sort((a, b) -> {
            var compare = Double.compare(b.gpa, a.gpa);
            if (compare == 0)
                compare = Long.compare(a.id, b.id);
            return compare;
        });
        for (Student student : listStudents) {
            sb.append(student).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {
        long id;
        double totalGrade;
        double gpa;
        long totalSubjects;

        public Student(long id) {
            this.id = id;
        }

        public void calGpa() {
            gpa = totalGrade / totalSubjects;
        }

        @Override
        public String toString() {
            gpa = (double)Math.round(gpa * 1000) / 1000;
            String res = "";
            return res.join(" ",Long.toString(this.id) , Double.toString(gpa));
        }

    }
}
