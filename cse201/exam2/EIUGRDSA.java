
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EIUGRDSA {
    static int p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        p = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Student> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            map.put(id, new Student(id));
        }
        for(int i=0; i<p; i++){
            sc.next();
        }
        for(int i=0; i<m; i++){
            int id = sc.nextInt();
            if(map.containsKey(id)){
                var a = map.get(id);
                a.addGrade(sc.nextInt(),sc.nextInt());
            }
        }
        ArrayList<Student> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(a->sb.append(a.toString()).append("\n"));
        System.out.println(sb);
    }
    static class Student{
        HashMap<Integer, Integer> subject = new HashMap<>();
        int id;
        public Student(int id) {
            this.id = id;
        }
        public void addGrade(int code, int grade){
            subject.put(code, Math.max(subject.getOrDefault(code,0),grade));
        }
        public int getAvg(){
            int sum=0;
            for(int a : subject.values()){
                sum+=a;
            }
            return sum/p;
        }
        @Override
        public String toString(){
            return id+" "+getAvg();
        }
    }
}
