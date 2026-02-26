import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class App {
  static Scanner sc = new Scanner(System.in);
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    String s = "aaaaaaaaaaaaaabb";
    System.out.println(compressedString(s));

  }

  public static String compressedString(String word) {
   //  aa aa aa aa aa aa aa
    for (int i = 0; i < word.length(); i++) {
      int count  = 1;
      for (int j = i+1; j < word.length(); j++) {
           if ( word.charAt(i) != word.charAt(j)) {
              break;
           }
           count++;
           if (count== 9) {
                break;
           }
      }
      sb.append(count+Character.toString(word.charAt(i)));
      i+=count -1;
    }

    return sb.toString();
  }
}
