
import java.util.ArrayList;
import java.util.Scanner;

public class EISCH2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        ArrayList<student> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String name = sc.next();
            int lenght = sc.nextInt();
            student st = new student(name);
            for(int j=0; j<lenght; j++){
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
        //A
        int i =0;
        double endStudent = list.get(n/12).avr;
        for(; i<n/12; i++){
            if(Double.compare(endStudent, list.get(i).avr)==0){
                break;
            }
            list.get(i).setGroup("A");
        }
        //B
        endStudent = list.get(n/3).avr;
        for(; i<n/3; i++){
            if(Double.compare(endStudent, list.get(i).avr)==0){
                break;
            }
            list.get(i).setGroup("B");
        }
        // C
        endStudent = list.get(n/2).avr;
        for(; i<n/2; i++){
            if(Double.compare(endStudent, list.get(i).avr)==0){
                break;
            }
            list.get(i).setGroup("C");
        }
        list.forEach(p->{
            if(p.group!=null){
                sb.append(p).append("\n");
            }
            else{
                return;
            }
        });
        System.out.println(sb);
    }
    static class student{
        String name;
        double sum =0;
        int count=0;
        double avr =0;
        String group;
        public student(String name) {
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                sum+=grade;
                count++;
                avr=sum/count;
            }
        }
        public void setGroup(String group){
            this.group=group;
        }
        @Override
        public String toString() {
            return  name + " " + String.format("%.2f", avr) + " " + group;
        }
        
    }
}
