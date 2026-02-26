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
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            map.put(id, new Student(id));
        }
        for(int i=0; i<p; i++){
            arr.add(sc.nextInt());
        }
        for(int i=0; i<m; i++){
            int id = sc.nextInt();
            int code = sc.nextInt();
            int grade = sc.nextInt();
            if(map.containsKey(id) && arr.contains(code)){
                map.get(id).addGrade(code, grade);
            }
        }
        ArrayList<Student> list = new ArrayList<>();
        map.forEach((key,val)->{
            val.getAvr();
            list.add(val);
        });
        list.sort((p1,p2)->{
            int a = Integer.compare(p2.avg, p1.avg);
            if(a!=0){
                return a;
            }
            int b = Integer.compare(p1.count, p2.count);
            if(b!=0){
                return b;
            }
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(l->sb.append(l).append("\n"));
        System.out.println(sb);
    }
    static class Student{
        int id;
        int count =0;
        int avg = 0;
        HashMap<Integer, Integer> subject = new HashMap<>();

        public Student(int id) {
            this.id = id;
        }
        public void addGrade(int code, int grade){
            count ++;
            subject.put(code, Math.max(subject.getOrDefault(code, 0),grade));
        }
        public void getAvr(){
            int sum = 0;
            for(var t : subject.values()){
                sum+=t;
            }
            avg = sum/p;
        }

        @Override
        public String toString() {
            return id + " " + avg+" "+count;
        }

    }
}
