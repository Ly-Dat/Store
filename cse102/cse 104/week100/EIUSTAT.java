
import java.util.Scanner;

public class EIUSTAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_student= sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int count =0;
        for(int i=0; i<num_student; i++){
            String name = sc.next();
            int point = sc.nextInt();
            if(point>=50){
                sb.append(name+"\n");
                count ++;
            }
        }
        sb.append(count+" "+(num_student-count));
        System.out.println(sb);
    }
}
