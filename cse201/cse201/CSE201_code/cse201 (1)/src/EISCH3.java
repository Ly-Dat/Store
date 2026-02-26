import java.util.*;
import java.io.*;

 class EISCH3 {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();
    static int countI;

    public static void main(String[] args) {
        var nStudents = sc.nextInt();

        Map<String, Department> mapDepartment = new HashMap<>();

        var listStudents = new ArrayList<Student>(nStudents);
        for (int i = 0; i < nStudents; i++) {
            var name = sc.next();
            var department = sc.next();
            var nSubjects = sc.nextInt();
            var totalGrade = getTotalGrade(nSubjects);

            if (!mapDepartment.containsKey(department))
                mapDepartment.put(department, new Department(department));

            listStudents.add(new Student(name, department, (double) totalGrade / (double) nSubjects));
        }

        listStudents.sort((a, b) -> {
            var compare = Double.compare(b.gpa, a.gpa);
            return compare == 0 ? a.name.compareTo(b.name) : compare;
        });

        var mapTopHIghestGPA = new TreeMap<Double, ArrayList<Student>>((a,b) -> Double.compare(b, a));
        var count = 0;
        for (Student student : listStudents) {
            Department department = mapDepartment.get(student.department);
            if (department.nScholarships < 2) {
                if (!mapTopHIghestGPA.containsKey(student.gpa)) {
                    var list = new ArrayList<Student>();
                    list.add(student);
                    mapTopHIghestGPA.put(student.gpa, list);
                } else {
                    mapTopHIghestGPA.get(student.gpa).add(student);
                }
                count++;
                department.nScholarships++;
            }
            if (count > 10) {
                break;
            }
        }
        countI = 0;
        mapTopHIghestGPA.forEach((a, b) -> {
            if (countI + b.size() < 3) {
                for (Student student : b) {
                    student.scholarshipType = "A";
                    sb.append(student).append("\n");
                }

            } else if (countI + b.size() < 6) {
                for (Student student : b) {
                    student.scholarshipType = "B";
                    sb.append(student).append("\n");
                }

            } else if (countI + b.size() < 11) {
                for (Student student : b) {
                    student.scholarshipType = "C";
                    sb.append(student).append("\n");
                }
            }
            countI += b.size();
        });
        System.out.println(sb);
    }

    private static int getTotalGrade(int nSubjects) {
        int totalgrade = 0;
        for (int i = 0; i < nSubjects; i++) {
            totalgrade += sc.nextInt();
        }
        return totalgrade;
    }

    static class Student {
        String name;
        String department;
        double gpa;
        double roundedGpa;
        String scholarshipType;

        public Student(String name, String department, double gpa) {
            this.name = name;
            this.department = department;
            this.gpa = gpa;
            this.roundedGpa = Math.round(this.gpa * 100.0) / 100.0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(this.name).append(" ").append(this.roundedGpa).append(" ").append(scholarshipType)
                    .toString();
        }
    }

    static class Department {
        String name;
        int nScholarships;

        public Department(String name) {
            this.name = name;
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
