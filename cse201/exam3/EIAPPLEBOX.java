
import java.util.Scanner;

public class EIAPPLEBOX {
    static long[] temp;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            count=0;
            int N = sc.nextInt();
            long A = sc.nextInt();
            long P = sc.nextLong();
            long[] arr = new long[N];
            temp = new long[N];
            arr[0] = (A*A)%P;
            for(int j=1; j<N; j++){
                arr[j]= (arr[j-1]*A)%P;
            }
            mergeSort(arr, 0, N-1);
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
    static void mergeSort(long[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int mid = (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);

    }
    static void merge(long[] arr, int left,int mid, int right){
        int i = left;
        int j = mid+1;
        int k = left;
        while(i<=mid && j<=right){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
                count+= mid+1-i;
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=right){
            temp[k++]=arr[j++];
        }
        for(int m =left; m<=right; m++){
            arr[m]=temp[m];
        }
    }
}
