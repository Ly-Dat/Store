import java.util.*;

public class EITASKDIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();

        var priorityQueue = new PriorityQueue<Worker>((w1, w2) -> {
            var compare = w1.workingHours - w2.workingHours;
            if (compare == 0) {
                compare = w1.index - w2.index;
            }
            return (int) compare;
        });
        var workerList = new ArrayList<Worker>();
        for (int i = 0; i < n; i++) {
            var worker = new Worker(i);
            workerList.add(worker);
            priorityQueue.add(worker);
        }

        var tasks = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            tasks.add(i, sc.nextInt());
        }
        Collections.sort(tasks, Collections.reverseOrder());

        for (Integer task : tasks) {
            Worker w = priorityQueue.poll();
            w.workingHours += task;
            priorityQueue.add(w);
        }

        for (Worker w : workerList) {
            sb.append(w.workingHours).append(' ');
        }
        System.out.println(sb);
    }

    static class Worker {
        int index;
        long workingHours;

        public Worker(int index) {
            this.index = index;
        }
    }
}