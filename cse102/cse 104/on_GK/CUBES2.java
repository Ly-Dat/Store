
import java.util.Scanner;

public class CUBES2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            long bricks=sc.nextLong();
            long layer=(long)Math.cbrt(6*bricks);
            if((layer*(layer+1)*(layer+2)/6)>bricks){
                layer--;
            }
            sb.append(layer+" ");
        }
        System.out.println(sb);
    }
}
