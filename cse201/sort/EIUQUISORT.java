import java.util.Scanner;

class EIUQUISORT {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        quickSort(arr, 0, n-1);
        for(int i=0; i<n; i++){
            sb.append(arr[i]+"\n");
        }
        System.out.println(sb);
    }

    static void quickSort(int[] arr, int left, int right){
        int i = divide(arr, left, right);
        if(left < i-1){
            quickSort(arr, left, i-1);
        }
        if(right > i){
            quickSort(arr, i, right);
        }
    }
    
    static int divide(int[] arr, int left, int right){
        int pivot = arr[(right+left)/2];
        while(left <= right){
            while(arr[left] < pivot){
                left++;
            }
            while(arr[right] > pivot){
                right--;
            }
            if(left<=right){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                left++;
                right--;
            }
        }
        return left;
    }
}