
import java.util.Scanner;

public class EIDORM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rooms = sc.nextInt();
        int count =0;
        for(int i=0; i<rooms; i++){
            int peoplIn = sc.nextInt();
            int maxPeople = sc.nextInt();
            if(maxPeople-peoplIn>=2){
                count++;
            }
        }
        System.out.println(count);
    }
}
