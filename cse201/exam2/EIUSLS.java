
import java.util.LinkedList;
import java.util.Scanner;

public class EIUSLS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        LinkedList<Student> list = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Student st = new Student(sc.next());
            int subject = sc.nextInt();
            for (int j = 0; j < subject; j++) {
                st.addGrade(sc.nextInt());
            }
            list.add(st);
        }
        list.sort((p1, p2) -> {
            return Double.compare(p2.getAvr(), p1.getAvr());
        });
        for (int i = 0; i < Math.min(2, n); i++) {
            System.out.println(list.get(i).name);
        }

    }

    static class Student {

        String name;
        double sum = 0;
        int count = 0;
        double avr;

        public Student(String name) {
            this.name = name;
        }

        public void addGrade(int grade) {
            sum += grade;
            count++;
        }

        public double getAvr() {
            return sum / count;
        }
    }
}
