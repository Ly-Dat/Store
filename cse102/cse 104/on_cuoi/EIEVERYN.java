import java.util.Scanner;

public class EIEVERYN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tescase = sc.nextInt();
        for(int i=0; i<tescase; i++){
            int num = sc.nextInt();
            int find = sc.nextInt();
            boolean flag = true;
            boolean[] check = new boolean[find+1];
            for(int j=0; j<num; j++){
                int a = sc.nextInt();
                if(a<=find){
                    check[a]=true;
                }
            }
            for(int j=1; j<=find; j++){
                if(!check[j]){
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
