import java.util.*;

public class EIUINV {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double maxMoney = sc.nextDouble();
        double[] moneyPerMonth = new double[12];
        setArr(moneyPerMonth);
        System.out.println(findRate(maxMoney, moneyPerMonth));
    }

    private static double findRate(double maxMoney, double[] moneyPerMonth) {

        double low = 0.0, high = 1.0;
        double precision = 0.0000001;
        while (Double.compare(high - low, precision) > 0) {
            double middle = (high + low) / 2;
            double totalMoney = calculateMaxSaving(moneyPerMonth, middle);
            int cmp = Double.compare(totalMoney, maxMoney);
            if (cmp > 0) {
                high = middle;
            } else if (cmp < 0)
                low = middle;
            else
                return middle;
        }
        return low;
    }

    private static void setArr(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextDouble();
        }
    }

    public static double calculateMaxSaving(double[] moneys, double rate) {
        double res = 0.0;
        for (int i = 0, j = moneys.length - 1; i < moneys.length; i++, j--) {
            if (moneys[i] != 0.0)
                res += moneys[i] * Math.pow((1.0 + rate), j);
        }
        return res;
    }
}
