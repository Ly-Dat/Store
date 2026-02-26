
import java.util.HashMap;
import java.util.Scanner;

public class EIUTRANS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m =sc.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<m; i++){
            map.put(sc.next(),sc.next());
        }
        for(int i=0; i<n; i++){
            String a = sc.next();
            if(map.get(a).length()<a.length()){
                sb.append(map.get(a)+" ");
            }
            else{
                sb.append(a+" ");
            }
        }
        System.out.println(sb);
    }
}
