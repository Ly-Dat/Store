import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class EIUGRADE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        HashMap<Integer, Student> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            int code = sc.nextInt();
            if(!map.containsKey(id)){
                Student st = new Student(id);
                map.put(id, st);
            }
            map.get(id).addGrade(sc.nextDouble());
        }
        ArrayList<Student> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            int a =Double.compare(p2.avr, p1.avr);
            if(a!=0){
                return a;
            }
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(p->sb.append(p).append("\n"));
        System.out.println(sb);
        System.out.println("xin chào các bạn");
    }

    static class Student {

        int id;
        double sum = 0;
        int count = 0;
        double avr = 0;

        public Student(int id) {
            this.id = id;
        }

        public void addGrade(double grade) {
            sum += grade;
            count ++;
            avr = sum / count;
        }

        @Override
        public String toString() {
            return id + " " + String.format("%.3f", avr);
        }

    }
}
