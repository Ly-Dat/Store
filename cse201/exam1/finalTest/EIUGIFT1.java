
import java.util.Arrays;
import java.util.Scanner;

public class EIUGIFT1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrGift = input(n);
        int[] arrPaper = input(m);
        Arrays.sort(arrGift);
        Arrays.sort(arrPaper);
        int i=0;
        int j=0;
        int count =0;
        while(i<arrGift.length && j<arrPaper.length){
            if(arrPaper[j]>=arrGift[i]*2 && arrPaper[j]<=arrGift[i]*3){
                count++;
                i++;
                j++;
            }
            else if(arrPaper[j]<arrGift[i]*2){
                j++;
            }
            else{
                i++;
            }
        }
        System.out.println(count);
    }
    static int[] input(int a){
        int[] arr = new int[a];
        for(int i=0; i<a; i++){
            arr[i]= sc.nextInt();
        }
        return arr;
    }
}
