import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

 class EIUAPPEA{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        
        for(int i =0;i<n;i++){
            numbers[i]=sc.nextInt();
        }

        Map<Integer,Integer> countMap = new HashMap<>();

        for(int number:numbers){
             countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> resultList = new ArrayList<>(countMap.entrySet());
        
        
        
        Collections.sort(resultList, Collections.reverseOrder(Map.Entry.comparingByKey()));

        for (Map.Entry<Integer, Integer> entry : resultList) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }
}