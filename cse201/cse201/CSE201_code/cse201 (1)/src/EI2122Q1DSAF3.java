import java.util.*;

import java.io.*;

public class EI2122Q1DSAF3 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nEmployees = sc.nextInt();
        long wagePerHour = sc.nextLong();
        int nProductiveEmployees = sc.nextInt();
        int nRecords = sc.nextInt();
        Map<Integer, Worker> mapWorkers = new HashMap<>();
        while (nEmployees-- > 0) {
            int id = sc.nextInt();
            mapWorkers.put(id, new Worker(id, wagePerHour));
        }

        while (nProductiveEmployees-- > 0) {
            mapWorkers.get(sc.nextInt()).wagePerHour = sc.nextInt();// enter id and assign wage/hour = input from user
        }

        while (nRecords-- > 0) {
            Worker worker = mapWorkers.get(sc.nextInt()); // get worker by enter id from user and pass it in mapWorkers
            if (!worker.check_in) {
                worker.check_in = true;
                worker.check_inTime = sc.nextLong();
            } else {
                worker.check_in = false;
                long check_outTime = sc.nextLong();
                worker.totalWage += (check_outTime - worker.check_inTime) * worker.wagePerHour;
            }
        }

        List<Worker> listWorkers = new ArrayList<>(mapWorkers.values());
        listWorkers.sort((a, b) -> {
            return Integer.compare(a.id, b.id);
        });

        for (Worker worker : listWorkers) {
            sb.append(worker).append("\n").append("\n");
        }
        System.out.println(sb);
    }

    static class Worker {
        int id;
        boolean check_in = false;
        long check_inTime;
        long wagePerHour;
        long totalWage;

        public Worker(int id, long wagePerHour) {
            this.id = id;
            this.wagePerHour = wagePerHour;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(this.id).append(" ").append(this.totalWage).toString();
        }
    }
}
