import java.util.*;
import java.io.*;

public class EICREDIT {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var length = sc.nextInt();
        
        var students = new ArrayList<Student>(length);
        for (int i = 0; i < length; i++) {
            students.add(new Student(sc.next(), sc.nextInt()));
        }

        for (Student student : students) {
            sb.append(student).append("\n");
        }

        System.out.println(sb);
    }

    static class Student {
        String name;
        int numberOfAccumulatedCredits;

        public Student(String name, int n) {
            this.name = name;
            calculateAccumulatedCredits(n);
        }

        private void calculateAccumulatedCredits(int n) {
            for (int i = 0; i < n; i++) {
                var grade = sc.nextInt();
                if (grade >= 50){
                    numberOfAccumulatedCredits += 4;
                }
            }
        }
        @Override
        public String toString() {
            return this.name + " " + this.numberOfAccumulatedCredits;
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
