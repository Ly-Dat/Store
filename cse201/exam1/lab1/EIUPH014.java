
import java.util.Scanner;

public class EIUPH014 {
    static boolean check(int[] arr){
        if(arr[0]==arr[arr.length-1]){
            for(int i=0; i<arr.length-1; i++){
                if(arr[i]!=arr[i+1]){
                    return false;
                }
            }
            return true;
        }
        return false;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
            }
            int count =0;
            while(!check(arr)){
                if(count==1000){
                    count=-1;
                    break;
                }
                int first = arr[0];
                for(int i=0; i<n-1; i++){
                    arr[i]=Math.abs(arr[i+1]-arr[i]);
                }
                arr[n-1]=Math.abs(arr[n-1]-first);
                count++;
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
