import java.util.*;
import java.io.*;

public class EIUCONS {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var nOfLocals = sc.nextInt();
        var listLocals = new ArrayList<Local>(nOfLocals);
        for (int i = 0; i < nOfLocals; i++) {
            listLocals.add(new Local(sc.nextInt(), sc.nextLong(), sc.nextLong()));
        }

        long sum = 0;
        for (Local local : listLocals) {
            sum += local.bestLocation;
        }

        System.out.println(sum);
    }

    static class Local {
        long[] grades;
        long AGrade;
        long BGrade;
        long bestLocation;

        public Local(int n, long AGrade, long BGrade) {
            this.AGrade = AGrade;
            this.BGrade = BGrade;
            setGrades(n);
            findBestLocation();
        }

        private void setGrades(int n) {
            this.grades = new long[n];
            this.grades[0] = this.AGrade % this.BGrade;
            for (int i = 1; i < n; i++) {
                this.grades[i] = this.grades[i - 1] * this.AGrade % this.BGrade;
            }
        }

        private void findBestLocation() {
            bestLocation = grades[0];
            for (int i = 1; i < grades.length; i++) {
                if (bestLocation < grades[i]) {
                    bestLocation = grades[i];
                }
            }
        }

    }
}
