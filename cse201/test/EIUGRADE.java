
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class EIUGRADE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Double> mapSum = new HashMap<>();
        HashMap<Integer, Integer> mapCount = new HashMap<>();
        for(int i=0; i<num; i++){
            int id = sc.nextInt();
            String idSuject = sc.next();
            double point = sc.nextDouble();
            mapSum.put(id , mapSum.getOrDefault(id, 0.0)+point);
            mapCount.put(id , mapCount.getOrDefault(id, 0)+1);
        } 
        HashMap<Integer, Double> map = new HashMap<>();
        for(var key : mapSum.keySet()){
            map.put(key, mapSum.get(key)/mapCount.get(key));
        }
        LinkedHashMap<Integer, Double> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream().sorted((p1, p2)->{
            int a = Double.compare(p2.getValue(), p1.getValue());
            if(a==0){
                return Integer.compare(p1.getKey(), p2.getKey());
            }
            else{
                return a;
            }
        }).forEachOrdered(p->sortedMap.put(p.getKey(), p.getValue()));
        sortedMap.forEach((key,val)->sb.append(key+" "+val+"\n"));
        System.out.println(sb);
    }
}
