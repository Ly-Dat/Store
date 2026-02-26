
import java.util.ArrayList;
import java.util.Scanner;

public class EISTULI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        int highestStudent = sc.nextInt();
        ArrayList<Student> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Student student = new Student(sc.nextLong(), sc.next());
            int lenght = sc.nextInt();
            for (int j = 0; j < lenght; j++) {
                student.addScore(sc.nextInt());
            }
            arr.add(student);
        }
        // arr.stream().sorted((p1, p2) -> {
        //     return Double.compare(p2.avg, p1.avg);
        // });
        // if (num <= highestStudent) {
        //     for (var student : arr) {
        //         sb.append(student).append("\n");
        //     }
        //     System.out.println(sb);
        //     return;
        // }
        
        double a = (double)(arr.get(highestStudent).avg);
        
    }

    static class Student {

        long id;
        String name;
        double sum = 0;
        int credit = 0;
        int count = 0;
        double avg;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public void addScore(int score) {
            if (score >= 50) {
                credit += 4;
                count++;
                sum += score;
            }
            avg = sum / count;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(avg) + " " + credit;
        }

    }
}
