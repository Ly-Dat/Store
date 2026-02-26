
import java.util.ArrayList;
import java.util.Scanner;

public class EISCH2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        ArrayList<Student> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            Student student = new Student(sc.next());
            int subject = sc.nextInt();
            for(int j=0; j<subject; j++){
                student.addScore(sc.nextInt());
            }
            arr.add(student);
        }
        arr.sort((p1, p2)->{
            int a = Double.compare(p2.GPA, p1.GPA);
            if(a==0){
                return p1.name.compareTo(p2.name);
            }
            return a;
        });
        //A
        double endScore = arr.get(n/12).GPA;
        int i;
        for(i=0; i<n/12; i++){
            if(Double.compare(arr.get(i).GPA, endScore)==0){
                break;
            }
            arr.get(i).setGroup("A");
        }
        //B
        endScore = arr.get(n/3).GPA;
        for(; i<n/3; i++){
            if(Double.compare(arr.get(i).GPA, endScore)==0){
                break;
            }
            arr.get(i).setGroup("B");
        }
        //C
        endScore = arr.get(n/2).GPA;
        for(; i<n/2; i++){
            if(Double.compare(arr.get(i).GPA, endScore)==0){
                break;
            }
            arr.get(i).setGroup("C");
        }
        arr.forEach(p->{
            if(p.group!=null){
                sb.append(p).append("\n");
            }
            else{
                return;
            }
        });
        System.out.println(sb);
    }
    static class Student{
        String name;
        double sum;
        int count;
        double GPA;
        String group;
        public Student(String name) {
            this.name = name;
        }
        public void addScore(int score){
            if(score>=50){
                sum+=score;
                count++;
            }
            GPA = sum/count;
        }
        
        public void setGroup(String group) {
            this.group = group;
        }

        @Override
        public String toString() {
            return name + " " + GPA + " " + group;
        }   
    }
}