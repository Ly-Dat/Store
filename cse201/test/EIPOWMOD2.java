import java.util.Scanner;

class EIPOWMOD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long base = a%c;
        long result=1;
        while(b>0){
            if(b%2==1){
                result=(result%c)*(base%c)%c;
            }
            b/=2;
            base=(base%c)*(base%c)%c;
        }
        System.out.println(result);
        
    }
}
