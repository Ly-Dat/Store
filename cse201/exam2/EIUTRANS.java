
import java.util.HashMap;
import java.util.Scanner;

public class EIUTRANS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n =sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<m; i++){
            map.put(sc.next(), sc.next());
        }
        for(int j=0; j<n; j++){
            String word = sc.next();
            String a = map.get(word);
            if(a.length()<word.length()){
                sb.append(a+" ");
            }
            else{
                sb.append(word+" ");
            }
        }
        System.out.println(sb);
    }
}
