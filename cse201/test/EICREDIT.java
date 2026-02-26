
import java.util.Scanner;

public class EICREDIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        for(int i=0; i<num; i++){
            String id = sc.next();
            Student student = new Student(id);
            int numCourse = sc.nextInt();
            for(int j =0; j<numCourse; j++){
                student.addGrade(sc.nextInt());
            }
            sb.append(student).append("\n");
        }
        System.out.println(sb);
        
    }
    static class Student{
        String id;
        int totalCredit = 0;
        
        public Student(String id) {
            this.id = id;
        }

        public void addGrade(int grade){
            if(grade>=50){
                totalCredit+=4;
            }
        }

        @Override
        public String toString() {
            return id + " " + totalCredit;
        }
        
    }
        

    
}
