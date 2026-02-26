import java.util.*;
import java.io.*;

    public class EIUTRANS {
        static InputReader sc = new InputReader(System.in);
        static StringBuilder sb = new StringBuilder();
        public static void main(String[] args) {
            
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<String, String> BeoWillSend = new HashMap<>();

            for (int i = 0; i < m; i++) {
                String A = sc.next();
                String B = sc.next();
                if (A.length() <= B.length()) {
                    BeoWillSend.put(A, A);
                } else {
                    BeoWillSend.put(A, B);
                }
            }
           
           
            for(int i= 0; i<n; i++){
                String words= sc.next();
                if(BeoWillSend.containsKey(words)){
                    sb.append(BeoWillSend.get(words)).append(" ");
                }
            }
            System.out.println(sb);
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


