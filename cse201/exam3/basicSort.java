import java.util.Scanner;

public class basicSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("basic sort:");
        // bubbleSort(arr);
        // selectionSort(arr);
        insertionSort(arr);
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
    static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j =0; j< arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j+1, j);
                }
            }
        }
    }
    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int minIndex = i;
            for(int j =i+1; j<arr.length; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr, minIndex, i);
        }
    }
    static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int t = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>t){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=t;
        }
    }
    static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
