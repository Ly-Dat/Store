import java.util.LinkedList;
import java.util.Scanner;

public class EIGRADU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        LinkedList<Student> list = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Student st = new Student(sc.nextInt(),sc.next());
            int subject = sc.nextInt();
            for (int j = 0; j < subject; j++) {
                st.addGrade(sc.nextInt());
            }
            if(st.credit>=m){
                list.add(st);
            }
        }
        list.sort((p1,p2)->{
            int a = Integer.compare(p2.getAvg(), p1.getAvg());
            if(a!=0){
                return a;
            }
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(p->sb.append(p.toString()+"\n"));
        System.out.println(sb);
    }
    static class Student{
        int id;
        String name;
        double sum=0;
        int credit=0;
        int avg;
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                credit+=4;
                sum+=grade*4;
            }
        }
        public int getAvg(){
            return (int)(sum/credit);
        }
        @Override
        public String toString(){
            return id+" "+name+" "+getAvg();
        }
    }
}
