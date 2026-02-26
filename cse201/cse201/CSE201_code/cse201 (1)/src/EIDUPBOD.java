import java.util.*;
import java.io.*;

 class EIDUPBOD {
    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static List<Student> studentsList;

    public static void main(String[] args) {
        var length = sc.nextInt();
        Map<String, Student> studentsMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            var date = sc.nextInt();
            var month = sc.nextInt();
            var year = sc.nextInt();
            Student student = new Student(date, month, year);
            Student mappedStudent = studentsMap.put(student.dateOfBirth, student);
            if (mappedStudent == null) {
                student.setCountSameBirthday(1);
            } else {
                student.setCountSameBirthday(mappedStudent.getCountSameBirthday() + 1);
            }
        }

        studentsList = new ArrayList<>(studentsMap.size());

        studentsMap.forEach((k, v) -> {
            studentsList.add(v);
        });
        studentsList.sort((a, b) -> {
            int compare = a.year - b.year;
            if (compare == 0)
                compare = a.month - b.month;
            else
                return compare;
            if (compare == 0)
                compare = a.date - b.date;
            else
                return compare;
            return compare;
        });
        for (Student e : studentsList) {
            sb.append(e.dateOfBirth).append(" ").append(e.countSameBirthday).append("\n");
        }
        System.out.println(sb);
    }

    static class Student {
        private int date;
        private int month;
        private int year;
        private String dateOfBirth;
        private int countSameBirthday;

        public Student(int date, int month, int year) {
            this.date = date;
            this.month = month;
            this.year = year;
            dateOfBirth = toString();
        }

        public int getCountSameBirthday() {
            return countSameBirthday;
        }

        public void setCountSameBirthday(int countSameBirthday) {
            this.countSameBirthday = countSameBirthday;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(10);
            if (date < 10)
                sb.append("0");
            sb.append(date).append("/");
            if (month < 10)
                sb.append("0");
            sb.append(month).append("/").append(year);
            return sb.toString();
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
