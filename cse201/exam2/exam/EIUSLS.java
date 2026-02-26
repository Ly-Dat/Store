
import java.util.ArrayList;
import java.util.Scanner;

public class EIUSLS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Student st = new Student(sc.next());
            int length = sc.nextInt();
            for (int j = 0; j < length; j++) {
                st.addGrade(sc.nextInt());
            }
            list.add(st);
        }
        list.sort((p1, p2) -> {
            return Double.compare(p2.avg, p1.avg);
        });
        for (int i = 0; i < Math.min(2, list.size()); i++) {
            sb.append(list.get(i).name).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {

        String name;
        double sum = 0;
        int count = 0;
        double avg = 0;

        public Student(String name) {
            this.name = name;
        }

        public void addGrade(double grade) {

            this.sum += grade;
            this.count++;
            this.avg = sum / count;

        }

    }
}
