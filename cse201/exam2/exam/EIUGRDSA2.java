
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EIUGRDSA2 {
    static int p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Student> map = new HashMap<>();
        ArrayList<Integer> codes = new ArrayList<>();
        int n= sc.nextInt();
        p= sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            map.put(id, new Student(id));
        }
        for(int i=0; i<p; i++){
            codes.add(sc.nextInt());
        }
        for(int i=0; i<m; i++){
            int id =sc.nextInt();
            int code = sc.nextInt();
            int grade = sc.nextInt();
            if(map.containsKey(id) && codes.contains(code)){
                map.get(id).addGrade(code, grade);
            }
        }
        map.forEach((key, val)->val.Avg());
        ArrayList<Student> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
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
        list.forEach(a->sb.append(a.toString()).append("\n"));
        System.out.println(sb);
    }
    static class Student{
        int id;
        HashMap<Integer, Integer> subject = new HashMap<>();
        int avg;
        int count=0;
        public Student(int id) {
            this.id = id;
        }
        public void addGrade(int code, int grade){
            count++;
            subject.put(code, Math.max(subject.getOrDefault(code, 0),grade));
        }
        public void Avg(){
            int sum=0;
            for(int t : subject.values()){
                sum+=t;
            }
            avg = sum/p;
        }

        @Override
        public String toString() {
            return id+" "+avg+" "+count;
        }


    }
}
