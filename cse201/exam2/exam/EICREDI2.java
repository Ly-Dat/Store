import java.util.Scanner;

public class EICREDI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            Student st = new Student(sc.next());
            int numSubject = sc.nextInt();
            for(int j=0; j<numSubject; j++){
                st.addGrade(sc.nextInt());
            }
            sb.append(st.toString()+"\n");
        }
        System.out.println(sb);
    }
    static class Student{
        String name;
        int count=0;
        String grades = "";
        double sum;
        int avr=0;
        public Student(String name) {
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                this.sum+=grade;
                this.grades+=grade+" ";
                this.count++;
            }
            this.avr=(int)(sum/count);
        }

        @Override
        public String toString() {
            return name + " " +grades+avr;
        }

    }
}
