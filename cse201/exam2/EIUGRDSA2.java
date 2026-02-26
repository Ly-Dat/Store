
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class EIUGRDSA2 {
    static int p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Student> listStudent = new HashMap<>();
        ArrayList<Integer> listSubject = new ArrayList<>();
        int n = sc.nextInt();
        p = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            Student st = new Student(id);
            listStudent.put(id, st);
        }
        for(int j=0; j<p; j++){
            listSubject.add(sc.nextInt());
        }
        for(int k=0; k<m; k++){
            int id = sc.nextInt();
            int code =sc.nextInt();
            int score = sc.nextInt();
            if(listStudent.containsKey(id) && listSubject.contains(code)){
                listStudent.get(id).addGrade(code, score);
            }
        }
        ArrayList<Student> students = new ArrayList<>();
        listStudent.forEach((key,val)->{
            val.avg();
            students.add(val);
        });
        students.sort((p1,p2)->{
            int a = Integer.compare(p2.avg, p1.avg);
            int b = Integer.compare(p1.count, p2.count);
            if(a!=0){
                return a;
            }
            if(b!=0){
                return b;
            }
            return Integer.compare(p1.id, p2.id);
        });
        students.forEach(a->sb.append(a.toString()).append("\n"));
        System.out.println(sb);

    }
    static class Student{
        int id;
        HashMap<Integer, Integer> subject = new HashMap<>();
        int sum=0;
        int avg;
        int count=0;
        public Student(int id) {
            this.id = id;
        }
        public void addGrade(int code, int grade){
            count++;
            subject.put(code, Math.max(subject.getOrDefault(code, 0),grade));
        }
        public void avg(){
            for(int t : subject.values()){
                sum+=t;
            }
            avg = sum/p;
        }
        @Override
        public String toString() {
            return id + " "+avg+" "+count;
        }
        
        
    }
}
    