
import java.util.HashMap;
import java.util.Scanner;

public class EI2122Q1ADAM1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        HashMap<Integer, Integer> check = new HashMap<>();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt(); 
            check.put(arr[i], check.getOrDefault(arr[i], 0)+1);
        }
        int count=0;
        for(int i=0; i<N; i++){
            if(check.get(X+arr[i])!=null){
                count+=check.get(X+arr[i]);
            }
            check.put(arr[i], check.get(arr[i])-1);
        }
        System.out.println(count);

    }
}
