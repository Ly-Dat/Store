
import java.util.Scanner;

public class a2 {
    static boolean checkSame(int[] arr){
        if(arr[0]!=arr[arr.length-1]){
            return false;
        }
        for(int i=1; i<arr.length; i++){
            if(arr[i]!=arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            int n = sc.nextInt();
            if(n==0){
                break;
            }
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
            }
            int count=0;
            while(!checkSame(arr)){
                if(count==1000){
                    count=-1;
                    break;
                }
                count++;
                int first = arr[0];
                for(int j=0; j<n-1; j++){
                    arr[j]=Math.abs(arr[j+1]-arr[j]);
                }
                arr[n-1]=Math.abs(arr[n-1]-first);
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
}
