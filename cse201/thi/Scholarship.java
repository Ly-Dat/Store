import java.util.*;

class StockProfit {
    static class Transaction {
        String type;
        String stockCode;
        int quantity;
        int price;

        Transaction(String type, String stockCode, int quantity, int price) {
            this.type = type;
            this.stockCode = stockCode;
            this.quantity = quantity;
            this.price = price;
        }
    }

    static class Profit implements Comparable<Profit> {
        String stockCode;
        long profit;

        Profit(String stockCode, long profit) {
            this.stockCode = stockCode;
            this.profit = profit;
        }

        @Override
        public int compareTo(Profit other) {
            if (this.profit != other.profit) {
                return Long.compare(other.profit, this.profit);
            }
            return this.stockCode.compareTo(other.stockCode);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String, long[]> stockData = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();;
            String stockCode = sc.next();;
            int quantity = sc.nextInt();
            int price = sc.nextInt();

            long totalCost = (long) quantity * price;
            long fee = (long) (totalCost * 0.001);

            stockData.putIfAbsent(stockCode, new long[2]);
            if (type.equals("B")) {
                stockData.get(stockCode)[0] += totalCost + fee;
            } else if (type.equals("S")) {
                stockData.get(stockCode)[1] += totalCost - fee;
            }
        }

        List<Profit> profits = new ArrayList<>();

        for (Map.Entry<String, long[]> entry : stockData.entrySet()) {
            String stockCode = entry.getKey();
            long buyTotal = entry.getValue()[0];
            long sellTotal = entry.getValue()[1];
            long profit = sellTotal - buyTotal;
            profits.add(new Profit(stockCode, profit));
        }

        Collections.sort(profits);

        for (int i = 0; i < m && i < profits.size(); i++) {
            System.out.println(profits.get(i).stockCode + " " + profits.get(i).profit);
        }
    }
}
