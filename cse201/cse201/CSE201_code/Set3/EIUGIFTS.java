import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUGIFTS {
    public static void main(String[] args) {
      
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = -1;
        int min_diff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int left = 0;
        int right = n -1;
        while(left <right){
            if(arr[left]+arr[right]<=k){
                if (arr[left]+arr[right]>=sum && arr[right] - arr[left] <= min_diff){
                    sum = arr[left]+arr[right];
                    min_diff = arr[right]-arr[left];
                }
                left++;
            } else right--;

        }
        if (sum == -1){
            min_diff=-1;
        }
        System.out.println(sum+" "+min_diff);
    }
    static InputReader sc = new InputReader(System.in);
   

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
