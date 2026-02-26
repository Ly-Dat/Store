
import java.util.Scanner;

public class EIDORM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int room = sc.nextInt();
        int count = 0;
        for (int i = 0; i < room; i++) {
            int num = sc.nextInt();
            int maxNum = sc.nextInt();
            if (maxNum - num >=2) {
                count++;
            }
        }
        System.out.println(count);
        
    }
}
