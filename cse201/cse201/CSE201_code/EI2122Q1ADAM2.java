
import java.io.*;
import java.util.*;

public class EI2122Q1ADAM2 {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();
        int[] womenHeight = new int[M];
        int[] menHeight = new int[N];
        for (int i = 0; i < N; i++) {
            menHeight[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            womenHeight[i] = sc.nextInt();
        }
        Arrays.sort(menHeight);
        Arrays.sort(womenHeight);
        
         // Binary search for the minimum possible value of H
        int low = 0;
        int high = Math.max(menHeight[N - 1], womenHeight[M - 1]) - Math.min(menHeight[0], womenHeight[0]);
        int result = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (pairsAvailable(menHeight, womenHeight, N, M, X, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        sb.append(result);
        System.out.println(sb);
    }
      // Check if it's possible to form X pairs with max height difference <= H
    private static boolean pairsAvailable(int[] men, int[] women, int N, int M, int X, int H) {
        int i = 0;// pointer for men
        int j = 0;// pointer for women
        int pairs = 0;

        while (i < N && j < M) {
            if (Math.abs(men[i] - women[j]) <= H) {
                pairs++;
                i++;
                j++;
            } else if (men[i] < women[j]) {
                i++;
            } else {
                j++;
            }

            if (pairs >= X) {
                return true;
            }
        }

        return pairs >= X;
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
