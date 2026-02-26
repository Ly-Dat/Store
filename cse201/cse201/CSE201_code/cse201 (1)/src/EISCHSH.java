import java.util.*;
import java.io.*;

public class EISCHSH {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nStudents = sc.nextInt();
        var nScholarships = sc.nextInt();
        var queueStudent = new PriorityQueue<Student>(nStudents, (a, b) -> {
            var compare = Double.compare(b.gpa, a.gpa);
            return compare == 0 ? Long.compare(a.id, b.id) : compare;
        });
        // var listStudents = new ArrayList<Student>(nStudents);
        for (int i = 0; i < nStudents; i++) {
            var id = sc.nextLong();
            var name = sc.next();
            var nCourses = sc.nextInt();
            long totalGrade = 0;
            ;
            int nPassedCourses = 0;
            for (int j = 0; j < nCourses; j++) {
                var score = sc.nextInt();
                if (score > 49) {
                    totalGrade += score;
                    nPassedCourses++;
                }
            }
            if (nPassedCourses > 0)
                queueStudent.add(new Student(id, name, (double) totalGrade / (double) nPassedCourses));
        }

        // listStudents.sort((a, b) -> {
        // var compare = Double.compare(b.gpa, a.gpa);
        // return compare == 0 ? Long.compare(a.id, b.id) : compare;
        // });

        var smallestGPA = queueStudent.peek().gpa;

        for (int rank = 1, count = 0; !queueStudent.isEmpty();) {
            Student student = queueStudent.poll();

            if (Double.compare(student.gpa, smallestGPA) < 0) {
                rank = count + 1;
                smallestGPA = student.gpa;
            }
            if (rank <= nScholarships) {
                student.rank = rank;
                sb.append(student).append("\n");
                count++;
            } else
                break;
        }
        System.out.println(sb);
    }

    static class Student {
        long id;
        String name;
        double gpa;
        int rank;

        public Student(long id, String name, double gpa) {
            this.id = id;
            this.name = name;
            this.gpa = gpa;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(this.rank).append(" ").append(this.id).append(" ").append(this.name).append(" ")
                    .append(Math.round(this.gpa)).toString();
        }
    }

    
}
