import java.util.*;
import java.io.*;

public class EIUATTEND1 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        // to store students and can easily access them many times, the key is the
        // student's id
        Map<String, Student> studentMap = new HashMap<>();
        // to count the number of lessons in a subject.
        // The key is the subject's code and the value is the set of starting time of
        // this subject
        Map<Long, Set<Long>> nLessonsPerSubject = new HashMap<>();

        int size = sc.nextInt();
        while (size-- > 0) {
            long startTime = sc.nextLong();
            String student_ID = sc.next();
            long subject_Code = sc.nextLong();
            int check_in = sc.nextInt();
            // ask there is the student in this "studentMap"
            if (!studentMap.containsKey(student_ID)) {
                studentMap.put(student_ID, new Student(student_ID));
            }
            // ask there is the subject in this "nLessonsPerSubject"
            if (!nLessonsPerSubject.containsKey(subject_Code)) {
                nLessonsPerSubject.put(subject_Code, new HashSet<>());
            }
            // ask this subject has this lesson
            if (!nLessonsPerSubject.get(subject_Code).contains(startTime)) {
                nLessonsPerSubject.get(subject_Code).add(startTime);
            }
            Student student = studentMap.get(student_ID);
            // ask this subject has this lesson
            if (!student.subjectMap.containsKey(subject_Code)) {
                student.subjectMap.put(subject_Code, new HashSet<>());
            }
            // ask if student is in this lesson (check_in == 1), add this lesson in the set
            // of the "subjectMap" in the student
            if (check_in == 1) {
                student.subjectMap.get(subject_Code).add(startTime);
            }
        }
        // transfer to List which can sort list of students by ascending order of
        // student's ID
        List<Student> studentList = new ArrayList<>(studentMap.values());
        studentList.sort((a, b) -> {
            return Long.compare(a.numbered_ID, b.numbered_ID);
        });

        int totalAttendances = computeTotalAdttendance(nLessonsPerSubject);// total of lessons of all subjects
        for (Student student : studentList) {
            student.totalAttendances = computeTotalAdttendance(student.subjectMap);
            student.totalAbsences = totalAttendances - student.totalAttendances;
            sb.append(student.id).append(" ").append(student.totalAbsences).append(" ").append(student.totalAttendances)
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static int computeTotalAdttendance(Map<Long, Set<Long>> subjectMap) {
        int count = 0;
        for (Set<Long> subject : subjectMap.values()) {
            count += subject.size();
        }
        return count;
    }

    static class Student {
        String id;
        int totalAttendances;
        int totalAbsences;
        int numbered_ID;
        // the key is subject's code, and value is set of this student's attendances in
        // this subject
        Map<Long, Set<Long>> subjectMap = new HashMap<>();

        public Student(String id) {
            this.id = id;
            this.numbered_ID =Integer.parseInt(id.split("0", 1)[0]);
        }

    }
}
