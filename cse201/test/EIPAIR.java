
import java.util.HashMap;
import java.util.Scanner;

public class EIPAIR {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                int value = sc.nextInt();
                var count = map.get(value);
                if (count == null) {
                    map.put(value, 1);
                } else {
                    map.put(value, count + 1);
                }
            }
            int result=0;
            for(var kpv:map.keySet()){
                result+=(double)(map.get(kpv)-1)/2*(map.get(kpv));
            }
            sb.append(result+"\n");
        }
        System.out.println(sb);

    }
}
