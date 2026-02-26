
import java.util.ArrayList;
import java.util.Scanner;

public class EISCHSH {
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
            int a = Double.compare(p2.avr, p1.avr);
            if(a!=0){
                return a;
            }
            return Integer.compare(p1.id, p2.id);
        });
        int rank=1;
        sb.append(rank+" "+list.get(0)).append("\n");
        for(int i=1; i<list.size(); i++){
            if(Double.compare(list.get(i).avr, list.get(i-1).avr)!=0){
                rank = i+1;
            }
            if(rank<=k){
                sb.append(rank+" "+list.get(i)).append("\n");
            }
            else{
                break;
            }
        }
        System.out.println(sb);

    }
    static class Student{
        int id;
        String name;
        double sum=0;
        int count =0;
        double avr=0;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                sum+=grade;
                count++;
                avr=sum/count;
            }
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(avr);
        }

    }
}
