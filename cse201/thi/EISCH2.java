
import java.util.ArrayList;
import java.util.Scanner;

public class EISCH2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            Student st = new Student(sc.next());
            int length = sc.nextInt();
            for(int j=0; j<length; j++){
                st.addGrade(sc.nextInt());
            }
            list.add(st);
        }
        list.sort((p1,p2)->{
            int a = Double.compare(p2.avr, p1.avr);
            if(a!=0){
                return a;
            }
            return p1.name.compareTo(p2.name);
        });
        //a
        int i=0;
        double end = list.get(n/12).avr;
        for(;i<n/12; i++){
            if(Double.compare(list.get(i).avr, end)==0){
                break;
            }
            list.get(i).setGroup("A");
        }
        //b
        end = list.get(n/3).avr;
        for(;i<n/3; i++){
            if(Double.compare(list.get(i).avr, end)==0){
                break;
            }
            list.get(i).setGroup("B");
        }
        //c
        end = list.get(n/2).avr;
        for(;i<n/2; i++){
            if(Double.compare(list.get(i).avr, end)==0){
                break;
            }
            list.get(i).setGroup("C");
        }
        list.forEach(p->{
            if(p.group!=null){
                sb.append(p).append("\n");
            }
        });
        System.out.println(sb);
    }
    static class Student{
        String name;
        double sum=0;
        int count =0;
        double avr = 0;
        String group;
        public Student(String name) {
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                sum+=grade;
                count++;
                avr = sum/count;
            }
        }
        public void setGroup(String group){
            this.group=group;
        }
        @Override
        public String toString() {
            return name + " " + String.format("%.2f", avr) + " " + group;
        }
        
    }
}
