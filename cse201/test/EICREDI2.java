
import java.util.Scanner;

public class EICREDI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        String noValue = sc.nextLine();
        for(int i=0; i<num; i++){
            String name = sc.next();
            sb.append(name+" ");
            int length = sc.nextInt();
            int sum =0 ;
            int count=0;
            for(int j=0; j<length; j++){
                int point = sc.nextInt();
                if(point>=50){
                    sb.append(point+" ");
                    sum+=point;
                    count++;
                }
            }
            if (count!= 0) {
                sb.append(sum/count).append("\n");
             } else {
                sb.append(0).append("\n");
             }
        }
        System.out.println(sb);
    }
}
