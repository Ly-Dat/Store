
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EITASKDIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1,p2)->{
            int a = Integer.compare(p1[1], p2[1]);
            if(a!=0){
                return a;
            }
            return Integer.compare(p1[0], p2[0]);
        });
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            list.add(sc.nextInt());
        }
        list.sort((p1,p2)->p2-p1);
        for(int i=0; i<n; i++){
            queue.add(new int[]{i,0});
        }
        for(int i=0; i<m; i++){
            int[] worker = queue.poll();
            worker[1]+=list.get(i);
            queue.add(worker);
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int[] t = queue.poll();
            result[t[0]]=t[1];
        }
        for(var k : result){
            sb.append(k+" ");
        }
        System.out.println(sb);
    }
}
