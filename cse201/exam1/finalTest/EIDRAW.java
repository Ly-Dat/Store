import java.util.Scanner;

public class EIDRAW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int size = sc.nextInt();
        for(int i=0; i<size; i++){
            sb.append(" ".repeat(i)+"\\"+" ".repeat((size-1-i)*2)+"/"+" ".repeat(i*2)+"\\"+" ".repeat((size-1-i)*2)+"/"+"\n");
        }
        System.out.println(sb);
    }
}
