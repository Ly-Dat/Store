
import java.util.Scanner;

public class EIUTHU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String part1 = sc.nextLine();
        String part2 = sc.nextLine();
        int result = -1;
        for(int i=0; i<part1.length(); i++){
            if(part2.startsWith(part1.substring(i))){
                result = i+part2.length();
                break;
            }
        }
        if(result==-1){
            result=part1.length()+part2.length();
        }
        System.out.println(result);
    }
}
