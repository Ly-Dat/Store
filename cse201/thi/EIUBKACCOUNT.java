
import java.util.PriorityQueue;
import java.util.Scanner;

public class EIUBKACCOUNT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Accout> accouts = new PriorityQueue<>((p1,p2)->{
            int a = Long.compare(p1.money, p2.money);
            if(a!=0){
                return a;
            }
            a = Integer.compare(p1.trans, p2.trans);
            if(a!=0){
                return a;
            }
            return Integer.compare(p1.id, p2.id);
        });
        
    }

    static class Accout {

        int id;
        long money;
        int trans;

        public Accout(int id, long money, int trans) {
            this.id = id;
            this.money = money;
            this.trans = trans;
        }

    }
}
