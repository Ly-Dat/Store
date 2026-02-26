
import java.util.ArrayList;
import java.util.Scanner;

public class EISTULI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Student> arr = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0; i<n; i++){
            Student st = new Student(sc.nextLong(), sc.next());
            int lenght = sc.nextInt();
            for(int j=0; j<lenght; j++){
                st.addGrade(sc.nextInt());
            }
            arr.add(st);
        }
        arr.sort((p1,p2)->{
            return Double.compare(p2.getAvg(), p1.getAvg());
        });
        if(k>=arr.size()){
            arr.forEach(a->sb.append(a.toString()).append("\n"));
        }
        else{
            double studentK = arr.get(k).getAvg();
            for(int i=0; i<n; i++){
                if(Double.compare(arr.get(i).getAvg(), studentK)>0){
                    sb.append(arr.get(i).toString()).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
    static class Student{
        long id;
        String name;
        double sum=0;
        int count=0;
        int credit=0;
        public Student(long id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addGrade(int grade){
            if(grade>=50){
                sum+=grade;
                count++;
                credit+=4;
            }
        }
        public double getAvg(){
            if(count==0){
                return 0;
            }
            return sum/count;
        }
        @Override
        public String toString() {
            return id + " "+name+" "+Math.round(getAvg())+" "+credit;
        }
    }
}
