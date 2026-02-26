import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EITASKDIS {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nPeople = sc.nextInt();
        var nWorks = sc.nextInt();

        var listWorks = new ArrayList<Integer>(nWorks);
        for (int i = 0; i < nWorks; i++) {
            listWorks.add(sc.nextInt());
        }
        listWorks.sort((a, b) -> b - a);

        Comparator<Worker> comparator = new Comparator<>() {

            @Override
            public int compare(EITASKDIS.Worker o1, EITASKDIS.Worker o2) {
                var compare = o1.totalTimes - o2.totalTimes;
                if (compare > 0)
                    return 1;
                else if (compare == 0) {
                    compare = o1.id - o2.id;
                    if (compare > 0)
                        return 1;
                    else
                        return -1;
                } else
                    return -1;
            }

        };

        var queueWorker = new PriorityQueue<Worker>(nPeople, comparator);
        for (int i = 0; i < nPeople; i++) {
            queueWorker.add(new Worker(i, listWorks.get(i)));
        }
        for (int i = nPeople; i < nWorks; i++) {
            Worker worker = queueWorker.poll();
            worker.setTotalTimes(listWorks.get(i));
            queueWorker.offer(worker);
        }

        Worker[] arrWorkers = new Worker[nPeople];
        while (!queueWorker.isEmpty()) {
            Worker worker = queueWorker.poll();
            arrWorkers[worker.id] = worker;
        }

        for (Worker e : arrWorkers) {
            sb.append(e).append(" ");
        }
        System.out.println(sb);
    }

    static class Worker {
        int id;
        int totalTimes;

        public Worker(int id, int time) {
            this.id = id;
            setTotalTimes(time);
        }

        public void setTotalTimes(int time) {
            this.totalTimes += time;
        }

        @Override
        public String toString() {
            return Integer.toString(this.totalTimes);
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
