
import java.util.Scanner;

public class EIUPREIU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int size = sc.nextInt();

        sb.append(" "+"_".repeat(size/2)+" ".repeat(5+size/2)+"\n");
        for(int i=0; i<size/2-1; i++){
            sb.append("|"+" ".repeat(size/2)+" |".repeat(2)+" ".repeat(size/2)+"|"+"\n");
        }
        sb.append("|"+"_".repeat(size/2)+" |".repeat(2)+" ".repeat(size/2)+"|"+"\n");
        for(int i=0; i<size/2-1; i++){
            sb.append("|"+" ".repeat(size/2)+" |".repeat(2)+" ".repeat(size/2)+"|"+"\n");
        }
        sb.append("|"+"_".repeat(size/2)+" |".repeat(2)+"_".repeat(size/2)+"|");
        System.out.println(sb);
    }
}
