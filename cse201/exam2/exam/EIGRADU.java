import java.util.ArrayList;
import java.util.Scanner;

public class EIGRADU {

    public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> list = new ArrayList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<n; i++){
            Student st = new Student(sc.nextInt(), sc.next());
            int length = sc.nextInt();
            for (int j = 0; j < length; j++) {
                st.addGrade(sc.nextInt());
            }
            if(st.credit>=m){
                list.add(st);
            }
        }
        list.sort((p1,p2)->{
            int a = Integer.compare(p2.avg, p1.avg);
            if(a!=0){
                return a;
            }
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(a->sb.append(a.toString()).append("\n"));
        System.out.println(sb);
    }

    static class Student {
        int id;
        String name;
        int sum = 0;
        int count = 0;
        int avg = 0;
        int credit =0;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void addGrade(double grade) {
            if (grade >= 50) {
                credit+=4;
                this.sum += grade;
                this.count++;
                this.avg = sum / count;
            }
        }
        
        @Override
        public String toString() {
            return id + " "+name+" "+avg;
        }
    }
}
