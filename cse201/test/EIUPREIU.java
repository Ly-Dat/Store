
import java.util.Scanner;

public class EIUPREIU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int size = sc.nextInt();
        int space = size/2;
        sb.append(" "+"_".repeat(space)+" ".repeat(space+5)+"\n");
        for(int i=0; i<space-1; i++){
            sb.append("|"+" ".repeat(space+1)+"|"+" "+"|"+" ".repeat(space)+"|"+"\n");
        }
        sb.append("|"+"_".repeat(space)+" "+"|"+" "+"|"+" ".repeat(space)+"|");
        sb.append("\n");
        for(int i=0; i<space-1; i++){
            sb.append("|"+" ".repeat(space+1)+"|"+" "+"|"+" ".repeat(space)+"|"+"\n");
        }
        sb.append("|"+"_".repeat(space)+" "+"|"+" "+"|"+"_".repeat(space)+"|");
        System.out.println(sb);
    }
}
