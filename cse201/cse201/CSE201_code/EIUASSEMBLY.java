import java.util.Scanner;

public class EIUASSEMBLY {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nTestcases = sc.nextInt();
        long[] min_max_P = { 1, Integer.MAX_VALUE };
        while (nTestcases-- > 0) {
            int nRobots = sc.nextInt();
            long budget = sc.nextLong();
            long[] robotPs = new long[nRobots];
            long[] robotMs = new long[nRobots];
            setArray(robotPs, robotMs);
            if (budget == 0) {
                sb.append(findMinP(robotPs)).append("\n");
            } else {

                sb.append(findMaxP(robotPs, robotMs, min_max_P, budget)).append("\n");
            }

        }
        System.out.println(sb);
    }

    private static long findMinP(long[] robotPs) {
        long min = robotPs[0];
        for (int i = 1; i < robotPs.length; i++) {
            if (min > robotPs[i]) {
                min = robotPs[i];
            }
        }
        return min;
    }

    private static long findMaxP(long[] robotPs, long[] robotMs, long[] min_max_P, long budget) {
        long left = min_max_P[0];
        long right = min_max_P[1];
        long middle = 1;
        while (left <= right) {
            middle = left + ((right - left) >> 1);
            if (canBeMaxP(robotPs, robotMs, budget, middle)) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return right;
    }

    private static boolean canBeMaxP(long[] robotPs, long[] robotMs, long budget, long middle) {

        for (int i = 0; i < robotPs.length; i++) {
            if (middle > robotPs[i]) {
                long temp = (middle - robotPs[i]) * robotMs[i];
                if (temp > budget)
                    return false;
                budget -= temp;
            }
        }

        return true;
    }

    private static void setArray(long[] robotPs, long[] robotMs) {

        for (int i = 0; i < robotMs.length; i++) {
            robotPs[i] = sc.nextLong();
            robotMs[i] = sc.nextLong();
        }
    }

    // static class Robot {

    // }
}
