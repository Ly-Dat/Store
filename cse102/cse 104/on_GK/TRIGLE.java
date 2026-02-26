
import java.util.Arrays;
import java.util.Scanner;

public class TRIGLE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int count = 0;
        for(int j=n-1; j>=2; j--){
            int left = 0;
            int right = j-1;
            while(left<right){
                if(arr[left]+arr[right]>arr[j]){
                    count+=right-left;
                    right --;
                }
                else{
                    left++;
                }
            }
        }
        System.out.println(count);
    }
}
