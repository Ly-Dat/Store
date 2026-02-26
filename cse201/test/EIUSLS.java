
import java.util.ArrayList;
import java.util.Scanner;

public class EIUSLS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        ArrayList<Student> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String name = sc.next();
            int length = sc.nextInt();
            Student student = new Student(name);
            for (int j = 0; j < length; j++) {
                student.addGrade(sc.nextInt());
            }
            arr.add(student);
        }
        arr.sort((p1,p2)->{
            return Double.compare(p2.getAvg(), p1.getAvg());
        });
        for(int i=0; i<Math.min(2,arr.size()); i++){
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb);

    }
    static class Student{
        String name;
        int count=0;
        double sum=0;
        double avg;
        public Student(String name) {
            this.name = name;
        }
        public void addGrade(int grade){
            sum+=grade;
            count++;
            avg=sum/count;
        }
        public double getAvg() {
            return avg;
        }
        @Override
        public String toString() {
            return name;
        }
        
    }
}
