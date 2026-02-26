import java.util.Scanner;

public class test1 {
    public static void find(){
        Scanner sc = new Scanner(System.in);
        for(int i =0; i<10;i++){
            for(int j =0; j<10;j++){
                for(int k =0; k<10;k++){
                    if(i*i*i + j*j*j + k*k*k==i*100+j*10+k){
                        System.out.printf("a= %d, b= %d, c= %d \n",i,j,k);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        find();

    }
}