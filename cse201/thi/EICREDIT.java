
import java.util.Scanner;

public class EICREDIT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            Student st = new Student(sc.next());
            int length = sc.nextInt();
            for(int j=0; j<length; j++){
                st.addGrade(sc.nextInt());
            }
            sb.append(st).append("\n");
        }
        System.out.println(sb);
    }
    static class Student{
        String name;
        int credit;

        public Student(String name) {
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                credit+=4;
            }
        }

        @Override
        public String toString() {
            return name + " " + credit;
        }

    }
}