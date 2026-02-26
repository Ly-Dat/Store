
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EIUGRDSA {
    static int p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Student> map = new HashMap<>();
        int n = sc.nextInt();
        p = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            map.put(id, new Student(id));
        }
        for(int i=0; i<p; i++){
            sc.nextInt();
        }
        for(int i=0; i<m; i++){
            int id = sc.nextInt();
            if(map.containsKey(id)){
                map.get(id).addGrade(sc.nextInt(), sc.nextInt());
            }
        }
        ArrayList<Student> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(p->sb.append(p).append("\n"));
        System.out.println(sb);
    }
    static class Student{
        int id;
        HashMap<Integer, Integer> subject = new HashMap<>();
        public Student(int id) {
            this.id = id;
        }
        public void addGrade(int code,int grade){
            subject.put(code, Math.max(subject.getOrDefault(code, 0),grade));
        }
        public int getAvr(){
            int sum =0;
            for(var t: subject.values()){
                sum+=t;
            }
            return sum/p;
        }
        @Override
        public String toString() {
            return id + " "+ getAvr();
        }
        
    }
}
