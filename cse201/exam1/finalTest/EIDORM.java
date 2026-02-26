import java.util.Scanner;

public class EIDORM {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count =0;
        for(int i=0; i<n; i++){
            int ple = sc.nextInt();
            int maxPle = sc.nextInt();
            if(maxPle-ple>=2){
                count++;
            }
        }
        System.out.println(count);
    }
}