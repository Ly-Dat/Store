import java.util.Arrays;
import java.util.Scanner;

public class binaSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        double[] arr = new double[N];
        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0; i<M; i++){
            double a = sc.nextInt();
            int vt = ~binarySearch(arr, (double)a-0.0001);
            if (vt >= 0 && vt < arr.length && Double.compare(arr[vt], a) == 0) {
                sb.append(vt).append(" ");
            } else {
                sb.append("-1").append(" ");
            }
        }
        System.out.println(sb);
    }
    static int binarySearch(double[] arr, double value){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (right+left)/2;
            if(arr[mid]<value){
                left=mid+1;
            }
            else if(arr[mid]>value){
                right=mid-1;
            }
            else{
                return mid;
            }
        }
        return -(left + 1);
    }
}
