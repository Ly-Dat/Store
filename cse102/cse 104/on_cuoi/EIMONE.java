import java.util.Scanner;

public class EIMONE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr_money = {20, 10, 5, 1};
        int money = sc.nextInt();
        for(int i=0; i<4; i++){
            int count = money/arr_money[i];
            if(count!=0){
                System.out.println(arr_money[i]+" "+count);
            }
            money%=arr_money[i];
        }
    }
}