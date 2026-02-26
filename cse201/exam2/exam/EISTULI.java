import java.util.ArrayList;
import java.util.Scanner;

public class EISTULI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> list = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0; i<n; i++){
            Student st = new Student(sc.nextInt(), sc.next());
            int length = sc.nextInt();
            for(int j=0; j<length; j++){
                st.addGrade(sc.nextInt());
            }
            list.add(st);
        }
        list.sort((p1,p2)->{
            return Double.compare(p2.avg, p1.avg);
        });
        if(k>=list.size()){
            list.forEach(a->sb.append(a.toString()).append("\n"));
        }
        else{
            double studentK = list.get(k).avg;
            for(int i=0; i<n ;i++){
                if(Double.compare(list.get(i).avg, studentK)!=0){
                    sb.append(list.get(i).toString()).append("\n");
                }
                else{
                    break;
                }
            }
        }
        System.out.println(sb);
    }
    static class Student{
        int id;
        String name;
        double sum=0;
        int count = 0;
        double avg =0;
        int credit=0;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                credit+=4;
                sum+=grade;
                count++;
                avg = sum/count;
            }
        }

        @Override
        public String toString() {
            return id+" "+name+" "+Math.round(avg)+" "+credit;
        }

    }
}
