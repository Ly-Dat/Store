
import java.util.ArrayList;
import java.util.Scanner;

public class EISCHSH {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        int numAward = sc.nextInt();
        ArrayList<Student> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            long id = sc.nextLong();
            String name = sc.next();
            Student student = new Student(id, name);
            int numCourse = sc.nextInt();
            for (int j = 0; j < numCourse; j++) {
                student.addScore(sc.nextInt());
            }
            arr.add(student);
        }
        arr.sort((p1, p2) -> {
            if (p1.avg == p2.avg) {
                return Long.compare(p1.id, p2.id);
            } else {
                return Double.compare(p2.avg, p1.avg);
            }
        });
        double studentK = arr.get(numAward-1).avg;

        int rank  = 1;
        for (int i = 0; i < num; i++) {
            
            if (i >0 && Double.compare(arr.get(i).avg, arr.get(i-1).avg)!=0) {
                rank = i +1;
            }
            if (arr.get(i).avg >= studentK) {
                sb.append(rank).append(" ").append(arr.get(i)).append("\n");

            } else{
            	break;
            }
        }
        System.out.println(sb);

    }

    static class Student {

        long id;
        String name;
        double sum = 0;
        long count = 0;
        double avg;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public void addScore(int score) {
            if (score >= 50) {
                sum += score;
                count++;
            }
            if(count ==0 ) count=1;
            avg = sum / count;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + Math.round(avg);
        }

    }
}
