import java.util.*;

public class EISCH4 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nStudents = sc.nextInt();
        int nScholarships = sc.nextInt();
        int minimumPassedCourses = sc.nextInt() >> 2;
        double minimumGPA = sc.nextDouble();

        List<Student> studentList = new ArrayList<>(nStudents);
        while (nStudents-- > 0) {
            String name = sc.next();
            int nCourses = sc.nextInt();
            int totalGrade = 0;
            for (int i = 0, j = nCourses; i < j; i++) {
                int grade = sc.nextInt();
                if (grade < 50) {
                    nCourses--;
                    continue;
                }
                totalGrade += grade;
            }
            if (nCourses >= minimumPassedCourses) {
                if (nCourses <= 0) {
                    studentList.add(new Student(name, 0.0));
                } else {
                    double GPA = (double) totalGrade / (double) nCourses;
                    if (Double.compare(GPA, minimumGPA) >= 0) {
                        studentList.add(new Student(name, GPA));
                    }
                }
            }
        }

        studentList.sort((a, b) -> {
            int cmp = Double.compare(b.GPA, a.GPA);
            return cmp == 0 ? a.name.compareTo(b.name) : cmp;
        });

        double pivotGPA = nScholarships < studentList.size() ? studentList.get(nScholarships).GPA : -1.0;

        for (Student student : studentList) {
            if (Double.compare(student.GPA, pivotGPA) > 0)
                sb.append(student.toString()).append("\n");
            else
                break;
        }
        System.out.println(sb.toString());
    }

    static class Student {
        String name;
        double GPA;

        public Student(String name, double gPA) {
            this.name = name;
            GPA = gPA;
        }

        @Override
        public String toString() {
            return String.join(" ", name, Double.toString(GPA));
        }
    }
}
