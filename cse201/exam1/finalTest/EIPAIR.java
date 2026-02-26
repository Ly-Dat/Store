
import java.util.HashMap;
import java.util.Scanner;

public class EIPAIR {
    static long count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            count=0;
            int lenght = sc.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=0; j<lenght; j++){
                int a = sc.nextInt();
                map.put(a, map.getOrDefault(a, 0)+1);
            }
            map.forEach((key, val)->count+=(long)((double)(val-1)/2*val));
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
