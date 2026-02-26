
import java.util.ArrayList;
import java.util.Scanner;

public class EIGRADU {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> list = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Student st = new Student(sc.nextLong(),sc.next());
            int length = sc.nextInt();
            for (int j = 0; j < length; j++) {
                st.addGrade(sc.nextInt());
            }
            if(st.credit>=m){
                list.add(st);
            }
        }
        list.sort((p1, p2) -> {
            int a = Integer.compare(p2.avr, p1.avr);
            if(a!=0){
                return a;
            }
            return Long.compare(p1.id, p2.id);
        });
        list.forEach(p->sb.append(p).append("\n"));
        System.out.println(sb);
    }

    static class Student {
        long id;
        String name;
        int sum = 0;
        int credit = 0;
        int avr = 0;
        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public void addGrade(int grade) {
            if (grade >= 50) {
                sum += grade * 4;
                credit += 4;
                avr = sum / credit;
            }
        }
        @Override
        public String toString() {
            return id+" "+name + " " + avr;
        }
    }
}
