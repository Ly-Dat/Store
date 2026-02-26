
import java.util.LinkedHashSet;
import java.util.Scanner;

public class EIUPH011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<n; i++){
            set.add(sc.nextInt());
        }
        set.forEach(p->sb.append(p+" "));
        System.out.println(sb);
    }
}
