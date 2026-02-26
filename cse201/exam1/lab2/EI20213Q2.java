
import java.util.Scanner;
import java.util.TreeMap;


public class EI20213Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            map.put(a, map.getOrDefault(a, 0)+1);
        }
        map.forEach((key, val)->sb.append(key+" "+val+"\n"));
        System.out.println(sb);
    }
}