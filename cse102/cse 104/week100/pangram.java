import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class pangram {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String phrase = sc.nextLine().toLowerCase();
            Set<Character> letters = new HashSet<>();
            for (char c = 'a'; c <= 'z'; c++) {
                letters.add(c);
            }
            for (char c : phrase.toCharArray()) {
                letters.remove(c);
            }
            if (letters.isEmpty()) {
                System.out.println("pangram");
            } else {
                List<Character> missingLetters = new ArrayList<>(letters);
                Collections.sort(missingLetters);
                System.out.print("missing ");
                for (char c : missingLetters) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}
