import java.util.Scanner;

public class test2 {
    public static void find(int d){
        for(int i =0; i<10;i++){
            for(int j =0; j<10;j++){
                for(int k =0; k<10;k++){
                    if(i*j*k==d){
                        System.out.println(i+""+j+""+k);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int d = sc.nextInt();
       find(d);

    }
}
