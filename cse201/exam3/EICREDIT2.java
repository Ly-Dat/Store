
import java.util.Scanner;

public class EICREDIT2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String name = sc.next();
            int length = sc.nextInt();
            Student st = new Student(name);
            for(int j=0; j<length; j++){
                st.addGrade(sc.nextInt());
            }
            sb.append(st).append("\n");
        }
        System.out.println(sb);
    }
    static class Student{
        String name;
        String grades = "";
        int count =0;
        int sum = 0;
        int avr =0;
        public Student(String name) {
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                grades+=grade+" ";
                sum+=grade;
                count++;
                avr=sum/count;
            }
        }
        @Override
        public String toString(){
            return name+" "+grades+avr;
        }
    }
}