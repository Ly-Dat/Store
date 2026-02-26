import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EISTULI {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nOfStudent = sc.nextInt();
        var k = sc.nextInt();

        var listStudents = new ArrayList<Student>(nOfStudent);
        for (int i = 0; i < nOfStudent; i++) {
            var id = sc.nextInt();
            var name = sc.next();
            var nCourses = sc.nextInt();
            int[] grades = new int[nCourses];
            for (int j = 0; j < nCourses; j++) {
                grades[j] = sc.nextInt();
            }
            listStudents.add(new Student(id, name, grades));
        }

        listStudents.sort((a, b) -> {
            return Double.compare(b.gpa, a.gpa);
        });
        long gpa;
        if (k == nOfStudent)
            gpa = -1;
        else
            gpa = listStudents.get(k).roundedGPA;
        for (int i = 0; i < k; i++) {
            Student student = listStudents.get(i);
            if (gpa != student.roundedGPA) {
                sb.append(student).append("\n");
            }

        }
        System.out.println(sb);
    }

    static class Student {
        long id;
        String name;
        int[] grades;
        int nPassedCourses;
        int sumPassedGrades;
        double gpa;
        long roundedGPA;

        public Student(int id, String name, int[] grades) {
            this.id = id;
            this.name = name;
            this.grades = grades;
            calTotalPassedGrades();
            calGpa();
            this.roundedGPA = Math.round(this.gpa);
        }

        private void calGpa() {
            if (this.nPassedCourses > 0)
                this.gpa = (double) this.sumPassedGrades / this.nPassedCourses;
        }

        private void calTotalPassedGrades() {
            for (int i : grades) {
                if (i >= 50) {
                    this.sumPassedGrades += i;
                    this.nPassedCourses++;
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(this.id).append(" ").append(this.name).append(" ").append(this.roundedGPA).append(" ")
                    .append(this.nPassedCourses << 2).toString();
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
