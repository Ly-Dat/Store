import java.util.Scanner;

public class MergeSort {
    static long[] temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testcase = sc.nextInt();
        long[] arr = new long[testcase];
        temp = new long[testcase];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= sc.nextLong();
        }
        mergeSort(arr, 0, arr.length-1);
        for (Object elem : arr) {
            sb.append(elem+"\n");
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
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=right){
            temp[k++]=arr[j++];
        }
        for(int m = left; m<=right; m++){
            arr[m]=temp[m];
        }
    }
}