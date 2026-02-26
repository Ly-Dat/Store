import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class EIWORKER {
    static class Worker {
        String name;
        long earning;

        public Worker(String name, long earning) {
            this.name = name;
            this.earning = earning;
        }
    }

    public static void main(String[] args) {
        int mil = 1000000;
        long[] rank = {0, 5 * mil, 10 * mil, 18 * mil, 32 * mil, 52 * mil, 80 * mil, Long.MAX_VALUE};
        double[] rate = {0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35};

        int staff = ni();
        int goodWorker = ni();
        long moneyEachProduct = ni();

        Worker[] workers = new Worker[staff];

        for (int i = 0; i < staff; i++) {
            String name = ns();
            long product = ni();
            long minusMoney = ni();

            long income = moneyEachProduct * product;
            long taxableIncome = Math.max(0, income - 9000000 - minusMoney);
            double tax = 0;

            for (int j = 1; j < rank.length && taxableIncome > 0; j++) {
                if (taxableIncome > rank[j - 1]) {
                    tax += Math.min(rank[j] - rank[j - 1], taxableIncome - rank[j - 1]) * rate[j - 1];
                }
            }

            workers[i] = new Worker(name, income - Math.round(tax));
        }
        Arrays.sort(workers, (w1, w2) -> {
            if (w2.earning != w1.earning) return Long.compare(w2.earning, w1.earning);
            return w1.name.compareTo(w2.name);
        });
        StringBuilder sb = new StringBuilder();

        if(goodWorker==staff){
            for (int i = 0; i < goodWorker; i++) {
                sb.append(workers[i].name).append(" ").append(workers[i].earning).append("\n");
            }
        }
        else{
            for (int i = 0; i < goodWorker; i++) {
                if(workers[i].earning==workers[i+1].earning && workers[i+1].earning==workers[goodWorker].earning){
                    break;
                }
                else{
                    sb.append(workers[i].name).append(" ").append(workers[i].earning).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
}
