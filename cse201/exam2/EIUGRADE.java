import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EIUGRADE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Student> map = new HashMap<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int id = sc.nextInt();
            int idSubject = sc.nextInt();
            Student st = new Student(id);
            if(map.get(id)==null){
                map.put(id, st);
            }
            map.get(id).addGrade(sc.nextDouble());
        }
        
        ArrayList<Student> list = new ArrayList<>(map.values());
        list.sort((p1, p2)->{
            int avr = Double.compare(p2.avr, p1.avr);
            if(avr!=0){
                return avr;
            }
            return Integer.compare(p1.id, p2.id);
        });
        list.forEach(p->sb.append(p.toString()+"\n"));
        System.out.println(sb);
    }

    static class Student {

        int id;
        int count = 0;
        double sum;
        double avr = 0;

        public Student(int id) {
            this.id = id;
        }

        public void addGrade(double grade) {
            this.sum += grade;
            this.count++;
            this.avr = sum / count;
        }

        @Override
        public String toString() {
            return id + " " + avr;
        }

    }
}
