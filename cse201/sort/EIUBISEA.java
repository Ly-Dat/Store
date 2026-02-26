import java.util.Arrays;
import java.util.Scanner;


public class EIUBISEA {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            if(arr[0]==a){
                sb.append(0).append(" ");
            }
            else{
                sb.append(binarySearch(arr, a)).append(" ");
            }
        }
        System.out.println(sb);
    }
    static int binarySearch (int[] arr, int x){
        int left = 0;
        int right = arr.length-1;
        int result = -1;

        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid]<x){
                left=mid+1;
            }   
            else if(arr[mid]>x){
                right=mid-1;
            }
            else{
                result=mid;
                right = mid-1;
            }
        }
        return result;
    }
}
