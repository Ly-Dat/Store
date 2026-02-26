
import java.util.Scanner;

public class CREAM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long cream = sc.nextLong();
        long add = sc.nextLong();
        long add_cream=(cream-1)/(add-1);
        System.out.println(cream+add_cream);
    }
}
