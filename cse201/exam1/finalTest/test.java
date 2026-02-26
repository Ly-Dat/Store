import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int n = sc.nextInt();
        for(int i=0; i<n ; i++){
            int val = sc.nextInt();
            int key = sc.nextInt();
            map.computeIfAbsent(key, value -> new ArrayList<>()).add(val);
        }
        map.forEach((key, val)->{
            if(val.size()>1){
                for(int i=0; i<val.size(); i++){
                    sb.append(val.get(i)+" "+key+"\n");
                }
            }
            else{
                sb.append(val.get(0)+" "+key+"\n");
            }
        });
        System.out.println(sb);
    }
}