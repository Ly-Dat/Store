
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EIUGRDSA2 {
    static int p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        p = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Student> map = new HashMap<>();
        ArrayList<Integer> arrCode = new ArrayList<>();
        for(int i=0; i<n ; i++){
            int id = sc.nextInt();
            map.put(id, new Student(id));
        }
        for(int i=0; i<p ; i++){
            arrCode.add(sc.nextInt());
        }
        for(int i=0; i<m ; i++){
            int id = sc.nextInt();
            int code = sc.nextInt();
            int grade = sc.nextInt();
            if(map.containsKey(id) && arrCode.contains(code)){
                map.get(id).addGrade(code, grade);
            }
        }
        ArrayList<Student> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            int a = Integer.compare(p2.getAvr(), p1.getAvr());
            int b = Integer.compare(p1.count, p2.count);
            if(a!=0){
                return a;
            }
            if(b!=0){
                return b;
            }
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(p->sb.append(p).append("\n"));
        System.out.println(sb);
    }
    static class Student{
        int id;
        int count =0;
        HashMap<Integer, Integer> subject = new HashMap<>();
        public Student(int id) {
            this.id = id;
        }
        public void addGrade(int code, int grade){
            subject.put(code, Math.max(subject.getOrDefault(code, 0),grade));
            count++;
        }
        public int getAvr(){
            int sum = 0;
            for(var t : subject.values()){
                sum+=t;
            }
            return sum/p;
        }

        @Override
        public String toString() {
            return id+" "+getAvr()+" "+count;
        }

    }
}
