
import java.util.Scanner;

public class Fingers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] arr = {"cai", "tro", "giua", "ap ut", "ut"};
        int finger = num % 18;
        if (finger > 10) {
            finger = 20 - finger;
        }
        if (finger <= 5) {
            System.out.println("Ngon " + arr[finger - 1] + " cua ban tay trai");
        } else {
            System.out.println("Ngon " + arr[10 - finger] + " cua ban tay phai");
        }

    }
}
