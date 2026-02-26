
import java.util.Scanner;

public class EIAPPLEBOX {

    static long appleBox(int N, int A, long P) {
        if (N == 0) {
            return (A * A) % P;
        }
        return (appleBox(N - 1, A, P) * A) % P;
    }
    static long tohop(int n){
        return n*(n-1)/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int A = sc.nextInt();
            long P = sc.nextLong();
            int count=0;
            int sum=0;
            for (int j = 0; j <= N; j++) {
                if(appleBox(j, A, P)>appleBox(j+1, A, P)){
                    count++;
                }
                
            }
            System.out.println(tohop(count)+"\n");
        }
    }
}
