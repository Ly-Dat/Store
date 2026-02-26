import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

 class EIUPH014 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int length = reader.nextInt();
        if (length > 0) {
            do {
                int[] nums = setNums(length);
                int times = calculateLoopTimes(nums);
                sb.append(Integer.toString(times)).append("\n");
                length = reader.nextInt();
            } while (length != 0);

            System.out.println(sb.toString());
        } else {
            System.out.println(0);
        }

    }

    private static int calculateLoopTimes(int[] nums) {
        int count = 0;

        for (boolean flag = isEqualArray(nums); !flag && count < 1001; flag = isEqualArray(nums)) {
            ++count;
            int temp = nums[0];

            int var10001;
            int var10002;
            for (int i = 0; i < nums.length - 1; nums[var10001] = Math.abs(var10002 - nums[i])) {
                var10001 = i;
                var10002 = nums[i];
                ++i;
            }

            nums[nums.length - 1] = Math.abs(nums[nums.length - 1] - temp);
        }

        return count > 1000 ? -1 : count;
    }

    private static boolean isEqualArray(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        int[] var5 = nums;
        int var4 = nums.length;

        for (int var3 = 0; var3 < var4; ++var3) {
            int e = var5[var3];
            numsSet.add(e);
        }

        return numsSet.size() == 1;
    }

    private static int[] setNums(int length) {
        int[] nums = new int[length];

        for (int i = 0; i < length; ++i) {
            nums[i] = reader.nextInt();
        }

        return nums;
    }

    public static int count(int[] a, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {

            if (i == n - 1) {
                a[i] = a[i] - a[0];
            } else {
                a[i] = Math.abs(a[i] - a[i - 1]);
            }

        }
        return count;
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
