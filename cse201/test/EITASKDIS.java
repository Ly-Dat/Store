import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class EITASKDIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<m; i++){
            arr.add(sc.nextInt());
        }
        arr.sort((p1, p2)->Integer.compare(p2, p1));
        arr.forEach(p->sb.append(p+" "));
        System.out.println(sb);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i, arr.get(i));
        }
        int vt =0;
        for(int j=0; j<m/n-1; j++){
            vt+=n;
        }
    }
}
