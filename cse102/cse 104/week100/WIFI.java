
import java.util.Scanner;

public class WIFI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            long rows = sc.nextLong();
            long columns = sc.nextLong();
            long AP = (rows/3)*(columns/3);
            System.out.println(AP);
        }
    }
}
