
import java.util.LinkedHashMap;
import java.util.Scanner;

public class EIUPH011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int a =sc.nextInt();
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        map.forEach((key, val)->sb.append(key+" "));
        System.out.println(sb);
    }
}
