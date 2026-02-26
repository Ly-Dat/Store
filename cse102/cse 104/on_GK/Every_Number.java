import java.util.Scanner;

public class Every_Number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        for(int i=0; i<T; i++){
            boolean flag= true;
            int m = sc.nextInt();
            int n = sc.nextInt();
            boolean[] num_in = new boolean[n+1];
            for(int j=0; j<m; j++){
                int num = sc.nextInt();
                if(num<=n){
                    num_in[num]=true;
                }
            }
            for(int k=1; k<=n; k++){
                if(!num_in[k]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}