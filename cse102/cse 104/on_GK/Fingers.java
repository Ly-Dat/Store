
import java.util.Scanner;

public class Fingers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int finger = num%18;
        String[] ngon = {"cai","tro","giua", "ap ut", "ut"};
        if(finger>10){
            finger=20-finger;
        }
        if(finger<=5){
            System.out.println("Ngon "+ngon[finger-1]+" cua ban tay trai");
        }
        else{
            System.out.println("Ngon "+ngon[10-finger]+" cua ban tay phai");
        }
    }
}
