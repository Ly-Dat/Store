
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EIWORKER {
    static class Worker {
        String name;
        long earning = 0;
        public Worker(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int mil = 1000000;
        long[] rank = {0, 5 * mil, 10 * mil, 18 * mil, 32 * mil, 52 * mil, 80 * mil, Long.MAX_VALUE};
        double[] rate = {0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35};
        int staff = sc.nextInt();
        int good_worker = sc.nextInt();
        long money_eachProduct = sc.nextLong();

        Worker[] workers = new Worker[staff];

        for (int i = 0; i < staff; i++) {
            String name = sc.next();
            Worker worker = new Worker(name);
            long product = sc.nextLong();
            long minus_money = sc.nextLong();

            long money = money_eachProduct * product;
            double tax = money - 9000000 - minus_money;
            double sum_tax = 0;
            if (tax < 0) {
                tax = 0;
            } else {
                for (int j = 1; j < rank.length; j++) {
                    if (tax > rank[j - 1]) {
                        sum_tax += Math.min(rank[j] - rank[j - 1], tax - rank[j - 1]) * rate[j - 1];
                    }
                }
                tax = sum_tax;
            }
            worker.earning = Math.round(money - tax);
            workers[i] = worker;
        }
        Arrays.sort(workers, Comparator.comparing(w -> w.name));
        Arrays.sort(workers, (w1, w2) -> Long.compare(w2.earning, w1.earning));
        int t = good_worker;
        if(good_worker==staff){
            for (int i = 0; i < good_worker; i++) {
                sb.append(workers[i].name + " " + workers[i].earning + "\n");
            }
        }
        else{
            for (int i = 0; i < good_worker; i++) {
                if(workers[i].earning==workers[i+1].earning && workers[i+1].earning==workers[good_worker].earning){
                    break;
                }
                else{
                    sb.append(workers[i].name + " " + workers[i].earning + "\n");
                }
            }
        }
        System.out.println(sb);

    }
}
