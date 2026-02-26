import java.util.ArrayList;
import java.util.Scanner;

public class EIKMAX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        arr.sort((p1,p2)->p2-p1);
        for(int i=0; i<m; i++){
            sb.append(arr.get(i)+" ");
        }
        System.out.println(sb);
    }
}
