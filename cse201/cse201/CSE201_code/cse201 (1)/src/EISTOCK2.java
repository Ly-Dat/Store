import java.util.*;

import java.io.*;

public class EISTOCK2 {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        int nTransactions = sc.nextInt();
        Map<Long, Item> mapItems = new TreeMap<>();

        for (int i = 0; i < nTransactions; i++) {
            String sign = sc.next();
            long codeC = sc.nextLong();
            long quantityQ = sc.nextLong();
            long unitPriceP = sc.nextLong();
            int timeT = sc.nextInt();
            if (mapItems.containsKey(codeC)) {
                Item item = mapItems.get(codeC);

                if (sign.equals("+")) {
                    item.queueTransaction.add(new Transaction(timeT, quantityQ, unitPriceP));
                    item.totalQuantity += quantityQ;
                } else if (item.totalQuantity >= quantityQ) {
                    item.exportItem(quantityQ);
                }
            } else if (sign.equals("+")) {
                mapItems.put(codeC, new Item(codeC, quantityQ, unitPriceP, timeT));
            }
        }

        for (Item item : mapItems.values()) {
            if (item.totalQuantity > 0)
                sb.append(item).append("\n");
        }
        System.out.println(sb);
    }

    static class Item {
        long codeC;
        long totalQuantity;
        Queue<Transaction> queueTransaction;

        public Item(long codeC, long quantityQ, long unitPriceP, int timeT) {
            this.codeC = codeC;
            this.totalQuantity = quantityQ;
            this.queueTransaction = new ArrayDeque<>();
            queueTransaction.add(new Transaction(timeT, quantityQ, unitPriceP));
        }

        public long calAverageValue() {
            return totalQuantity > 0 ? calTotalValue() / totalQuantity : 0;
        }

        private long calTotalValue() {
            long totalValue = 0;
            for (Transaction transaction : queueTransaction) {
                totalValue += transaction.quantityQ * transaction.unitPriceP;
            }
            return totalValue;
        }

        public void exportItem(long quantityQ) {
            int size = queueTransaction.size();
            totalQuantity -= quantityQ;
            while (size-- > 0) {
                if (queueTransaction.peek().quantityQ > quantityQ) {
                    queueTransaction.peek().quantityQ -= quantityQ;
                    break;
                } else if (queueTransaction.peek().quantityQ == quantityQ) {
                    queueTransaction.remove();
                    break;
                } else {
                    quantityQ -= queueTransaction.poll().quantityQ;
                }
            }
        }

        public int getTimeOfOldestTransaction() {
            return queueTransaction.size() > 0 ? queueTransaction.peek().timeT : 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(codeC).append(" ").append(totalQuantity).append(" ").append(calAverageValue()).append(" ")
                    .append(getTimeOfOldestTransaction()).toString();
        }
    }

    static class Transaction {
        int timeT;
        long quantityQ;
        long unitPriceP;

        // long totalValue;
        public Transaction(int timeT, long quantityQ, long unitPriceP) {
            this.timeT = timeT;
            this.quantityQ = quantityQ;
            this.unitPriceP = unitPriceP;
        }

    }

    static class InputReader {
        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}