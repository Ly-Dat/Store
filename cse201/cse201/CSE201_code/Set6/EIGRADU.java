import java.util.*;

public class EIGRADU {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var length = sc.nextInt();
        var mimCredit = sc.nextInt();

        PriorityQueue<Student> pq =  new PriorityQueue<>(new Comparator<Student>() {

            @Override
            public int compare(EIGRADU.Student o1, EIGRADU.Student o2) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'compare'");
            }
            
        });

        var listStudents = new ArrayList<Student>(length);
        for (int i = 0; i < length; i++) {
            var id = sc.nextLong();
            var name = sc.next();
            var grades = new int[sc.nextInt()];
            for (int e : grades) {
                e = sc.nextInt();
            }
            Student stu = new Student(id, name, mimCredit, grades);
            if (stu.averageGrade != 0.0)
                listStudents.add(stu);
        }
        listStudents.sort((a, b) -> {
            var compare = Double.compare(b.averageGrade, a.averageGrade);
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
        String name;
        int nOfPassedCourses;
        double averageGrade;
        long sumGrade;
        int minCredit;
        int[] grades;

        public Student(long id, String name, int minCredit, int[] grades) {
            this.name = name;
            this.id = id;
            this.minCredit = minCredit;
            this.grades = grades;
            calAverageGrade();
        }

        private void calAverageGrade() {
            for (int i : this.grades) {
                if (i >= 50) {
                    this.sumGrade += i;
                    this.nOfPassedCourses++;
                }
            }
            if (this.nOfPassedCourses >= this.minCredit >> 2)
                this.averageGrade = (double) this.sumGrade / this.nOfPassedCourses;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.id).append(" ").append(this.name).append(" ").append((long)Math.floor(averageGrade));
            return sb.toString();
        }
    }
}
