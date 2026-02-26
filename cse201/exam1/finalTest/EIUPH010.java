
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EIUPH010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        ArrayList<String> result = new ArrayList<>();
        map.entrySet().stream().sorted((p1, p2)->{
            int m = Integer.compare(p2.getValue(), p1.getValue());
            if(m==0){
                return Integer.compare(p1.getKey(), p2.getKey());
            }
            return m;
        }).forEachOrdered(p->result.add(p.getKey()+" "+p.getValue()));
        System.out.println(result.get(0));
    }
}
