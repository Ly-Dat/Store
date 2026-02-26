import java.util.Arrays;
import java.util.Scanner;

public class a5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m = sc.nextInt();
        int[] arrGift = new int[n];
        int[] arrPaper = new int[m];
        for(int i=0; i<n; i++){
            arrGift[i]=sc.nextInt();
        }
        for(int i=0; i<n; i++){
            arrPaper[i]=sc.nextInt();
        }
        Arrays.sort(arrGift);
        Arrays.sort(arrPaper);
        int i=0;
        int j=0;
        int count=0;
        while(i<n && j<m){
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
}
