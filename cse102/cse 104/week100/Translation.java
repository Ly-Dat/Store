
import java.util.Scanner;

public class Translation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String letter_in = sc.nextLine();
        String letter_Aztecs = sc.nextLine();
        boolean flag = true;
        if (letter_Aztecs.length() == letter_in.length()) {
            for (int i = 0; i < letter_in.length(); i++) {
                if (letter_in.charAt(i) != letter_Aztecs.charAt(letter_in.length() - i - 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES"); 
            }else {
                System.out.println("NO");
            }
        }
        else{
            System.out.println("NO");
        }
    }
}
