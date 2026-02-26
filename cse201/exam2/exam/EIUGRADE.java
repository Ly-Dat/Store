
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EIUGRADE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Student> map = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            Student st = new Student(id);
            sc.nextInt();
            if (map.get(id) == null) {
                map.put(id, st);
            }
            map.get(id).addGrade(sc.nextDouble());
        }
        ArrayList<Student> list = new ArrayList<>(map.values());
        list.sort((p1, p2) -> {
            int a = Double.compare(p2.avg, p1.avg);
            if (a != 0) {
                return a;
            }
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(a -> sb.append(a.toString()).append("\n"));
        System.out.println(sb);
    }

    static class Student {

        int id;
        double sum = 0;
        int count = 0;
        double avg = 0;

        public Student(int id) {
            this.id = id;
        }

        public void addGrade(double grade) {

            this.sum += grade;
            this.count++;
            this.avg = sum / count;

        }

        @Override
        public String toString() {
            return id + " " + avg;
        }

    }
}
