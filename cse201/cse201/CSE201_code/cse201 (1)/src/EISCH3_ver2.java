import java.util.*;

import java.io.*;

public class EISCH3_ver2 {

    static InputReader rd = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nStudent = rd.nextInt();
        Map<String, List<Student>> mapDepartments = new HashMap<>();

        for (int i = 0; i < nStudent; i++) {
            String name = rd.next();
            String department = rd.next();
            int nSubjects = rd.nextInt();
            double gpa = (double) calTotalGrade(nSubjects) / (double) nSubjects;
            Student student = new Student(name, department, gpa);
            if (mapDepartments.containsKey(department)) {
                List<Student> listStudentInDepartment = mapDepartments.get(department);
                if (listStudentInDepartment.isEmpty()) {
                    listStudentInDepartment = new ArrayList<>();
                    listStudentInDepartment.add(student);
                    mapDepartments.put(department, listStudentInDepartment);
                } else {
                    listStudentInDepartment.add(student);
                }
            } else {
                List<Student> listStudentInDepartment = new ArrayList<>();
                listStudentInDepartment.add(student);
                mapDepartments.put(department, listStudentInDepartment);
            }
        }

        Comparator<Student> comparator = new Comparator<>() {

            @Override
            public int compare(Student o1, Student o2) {
                int cmp = Double.compare(o2.gpa, o1.gpa);
                return cmp == 0 ? o1.name.compareTo(o2.name) : cmp;
            }
        };

        List<Student> finalStudent = new ArrayList<>();
        for (List<Student> value : mapDepartments.values()) {
            value.sort(comparator);
            addStudent(finalStudent, value);
        }

        finalStudent.sort(comparator);

        int count = 0;
        double pivotGPA = 0.0;
        if (finalStudent.size() > 2)
            pivotGPA = finalStudent.get(2).gpa;
        for (; count < 2 && count < finalStudent.size(); count++) {
            Student student = finalStudent.get(count);
            if (Double.compare(student.gpa, pivotGPA) > 0) {
                student.typeScholarShip = "A";
                sb.append(student).append("\n");
            } else {
                break;
            }
        }

        pivotGPA = 0.0;
        if (finalStudent.size() > 5)
            pivotGPA = finalStudent.get(5).gpa;
        for (; count < 5 && count < finalStudent.size(); count++) {
            Student student = finalStudent.get(count);
            if (Double.compare(student.gpa, pivotGPA) > 0) {
                student.typeScholarShip = "B";
                sb.append(student).append("\n");
            } else {
                break;
            }
        }

        pivotGPA = 0.0;
        if (finalStudent.size() > 10)
            pivotGPA = finalStudent.get(10).gpa;
        for (; count < 10 && count < finalStudent.size(); count++) {
            Student student = finalStudent.get(count);
            if (Double.compare(student.gpa, pivotGPA) > 0) {
                student.typeScholarShip = "C";
                sb.append(student).append("\n");
            } else {
                break;
            }
        }
        System.out.println(sb);
    }

    private static void addStudent(List<Student> finalStudent, List<Student> value) {
        double pivotGPA = 0.0;
        if (value.size() > 2)
            pivotGPA = value.get(2).gpa;
        for (Student student : value) {
            if (Double.compare(student.gpa, pivotGPA) <= 0)
                break;
            finalStudent.add(student);
        }
    }

    private static int calTotalGrade(int nSubjects) {
        int total = 0;
        while (nSubjects-- > 0) {
            total += rd.nextInt();
        }
        return total;
    }

    static class Student {
        String name;
        String department;
        double gpa;
        double roundedGpa;
        String typeScholarShip;

        public Student(String name, String department, double gpa) {
            this.name = name;
            this.department = department;
            this.gpa = gpa;
            this.roundedGpa =  (Math.round(this.gpa * 100.0) / 100.0);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            return sb.append(this.name).append(" ")
                    .append(this.roundedGpa).append(" ")
                    .append(this.typeScholarShip).toString();
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
