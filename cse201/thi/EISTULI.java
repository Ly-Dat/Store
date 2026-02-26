import java.util.ArrayList;
import java.util.Scanner;

public class EISTULI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            Student st = new Student(sc.nextInt(), sc.next());
            int length = sc.nextInt();
            for(int j=0; j<length; j++){
                st.addGrade(sc.nextInt());
            }
            list.add(st);
        }
        list.sort((p1,p2)->{
            return Double.compare(p2.avr, p1.avr);
        });
        if(list.size()<=k){
            list.forEach(p->sb.append(p).append("\n"));
        }
        else{
            double end = list.get(k).avr;
            for(int i=0; i<list.size(); i++){
                if(Double.compare(list.get(i).avr, end)==0){
                    break;
                }
                sb.append(list.get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }
    static class Student{
        int id;
        String name;
        double sum=0;
        double avr=0;
        int credit =0;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                sum+=grade*4;
                credit+=4;
                avr=sum/credit;
            }
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(avr) + " " + credit;
        }
    }
}
