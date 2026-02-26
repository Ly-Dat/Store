
import java.util.ArrayList;
import java.util.Scanner;

public class EIGRADU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        int minCredit = sc.nextInt();
        ArrayList<Student> arr = new ArrayList<>();
        for(int i=0; i<num; i++){
            long id = sc.nextLong();
            String name = sc.next();
            Student student = new Student(id,name);
            int numCourse = sc.nextInt();
            for(int j =0; j<numCourse; j++){
                student.addGrade(sc.nextInt());
            }
            if(student.getCredit()>=minCredit){
                arr.add(student);
            }
        }
        arr.sort((p1,p2)->{
            if(p1.getAvg()==p2.getAvg()){
                return Long.compare(p1.getId(), p2.getId());
            }
            else{
                return Integer.compare(p2.getAvg(), p1.getAvg());
            }
        });
        for(var i:arr){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
    static class Student{
        long id;
        String name;
        double sum=0;
        int count=0;
        int credit=0;
        int avg;
        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                credit+=4;
                sum+=grade;
                count++;
            }
            avg=(int)(sum/count);
        }
        
        public int getCredit() {
            return credit;
        }
        
        public long getId() {
            return id;
        }
        public int getAvg() {
            return avg;
        }
        @Override
        public String toString() {
            return id + " " + name + " " + avg;
        }
        
    }
}
