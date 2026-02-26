
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        WordSet wordSet = new WordSet(line);
        System.out.println(wordSet);
    }
}
