import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

 class EISCHSH {

    public static void main(String[] args) {
       
        int n = sc.nextInt();
        int m = sc.nextInt();
        var students = new ArrayList<Student>();
        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();
            double grad =0;
            int count =0;
            int courses = sc.nextInt();
            for (int j = 0; j < courses; j++) {
                 int score = sc.nextInt();
                 if (score>= 50) {
                    grad+=score;
                    count++;
                 }
            }
            // if (count !=0) {
                students.add(new Student(id, name, grad/count));
            // } else{
            //     students.add(new Student(id, name, count));
            // }
        }
        students.sort((s1,s2)->{
            int cmp = Double.compare(s2.score, s1.score);
            if (cmp!= 0) {
                return cmp;
            }
            return Long.compare(s1.id, s2.id);
        });
        double studentK = students.get(m-1).score;
        StringBuilder  sb = new StringBuilder();

        int rank  = 1;
        for (int i = 0; i < n; i++) {
            
            if (i >0 && Double.compare(students.get(i).score, students.get(i-1).score)!=0) {
                rank = i +1;
            }
            if (students.get(i).score >= studentK) {
                sb.append(rank).append(" ").append(students.get(i)).append("\n");

            } else{
            	break;
            }
        }
        System.out.println(sb);

        
    }
    static class Student {
      long id ;
      String name;
      double score;
    public Student(long id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    @Override
    public String toString() {
        return  id + " " + name + " " + (int)Math.round(score );
    }
      
        
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
