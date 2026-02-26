import java.util.Scanner;
import java.util.TreeMap;

public class EIUONCE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int lenght = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for(int j=0; j<lenght; j++){
                int a =sc.nextInt();
                map.put(a, map.getOrDefault(a, 0)+1);
            }
            map.forEach((key, val)->{
                if(val==1){
                    sb.append(key+" ");
                }
            });
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
