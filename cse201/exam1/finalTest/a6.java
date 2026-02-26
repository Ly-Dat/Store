import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class a6 {
    static int vt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<m; i++){
            arr.add(sc.nextInt());
        }
        arr.sort((p1,p2)->p2-p1);
        PriorityQueue<int[]> minWork = new PriorityQueue<>((p1, p2)->{
            int a = Integer.compare(p1[1], p2[1]);
            if(a==0){
                return Integer.compare(p1[0], p2[0]);
            }
            return a;
        });
        for (int i = 0; i < n; i++) {
            minWork.offer(new int[]{i, 0});
        }
        for (int jobTime : arr) {
            int[] person = minWork.poll();  
            person[1] += jobTime;  
            minWork.offer(person);  
        }
        int[] result = new int[n];
        while (!minWork.isEmpty()) {
            int[] person = minWork.poll();
            result[person[0]] = person[1]; 
        }
        for (int i = 0; i < n; i++) {
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
}
