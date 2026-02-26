import java.util.*;
import java.io.*;

public class EIUATTEND2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nAttendance = sc.nextInt();
        Map<Long, ClassTime> classTimeMap = new HashMap<>();
        HashSet<Integer> studentSet = new HashSet<>();
        while (nAttendance-- > 0) {
            long time = sc.nextLong();
            int studentID = sc.nextInt();
            int classID = sc.nextInt();
            int attendanceOrNot = sc.nextInt();
            if (!studentSet.contains(studentID))
                studentSet.add(studentID);
            if (!classTimeMap.containsKey(time))
                classTimeMap.put(time, new ClassTime(time));
            if (attendanceOrNot == 1)
                classTimeMap.get(time).attendStudentList.add(studentID);
        }

        List<ClassTime> classTimeList = new ArrayList<>(classTimeMap.size());
        for (ClassTime classTime : classTimeMap.values()) {
            classTime.rate = classTime.attendStudentList.size() > 0
                    ? (double) classTime.attendStudentList.size() / (double) studentSet.size()
                    : 0.0;
            classTimeList.add(classTime);
        }
        classTimeList.sort((a, b) -> {
            int cmp = Double.compare(b.rate, a.rate);
            return cmp == 0 ? Long.compare(a.time, b.time) : cmp;
        });
        for (ClassTime classTime : classTimeList) {

            sb.append(classTime.time).append(" ").append(String.format("%.2f", classTime.rate)).append("\n");
        }
        System.out.println(sb);
    }

    static class ClassTime {
        long time;
        Set<Integer> attendStudentList = new HashSet<>();
        double rate;

        public ClassTime(long time) {
            this.time = time;
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
