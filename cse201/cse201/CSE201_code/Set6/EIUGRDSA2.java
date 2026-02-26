import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EIUGRDSA2 {
   static InputReader sc = new InputReader(System.in);
   static StringBuilder sb = new StringBuilder();
   public static void main(String[] args) {
    int stNum = sc.nextInt();
    int subjectNum = sc.nextInt();
    int submitNum = sc.nextInt();

    HashMap<Integer, Student> listStudent = new HashMap<>();
	ArrayList<Integer> listCourses = new ArrayList<>();

	for(int i =0;i<stNum;i++){
		int IDs = sc.nextInt();
		listStudent.put(IDs, new Student(IDs, subjectNum));
	}

	for(int j =0;j<subjectNum;j++){
		listCourses.add(sc.nextInt());
	}

	for(int m =0;m<submitNum;m++){
		int id = sc.nextInt();
		int course = sc.nextInt();
		int grade = sc.nextInt();

		Student st = listStudent.get(id);
		if(listCourses.contains(course)){
			st.setGrade(course, grade);
		}
	}

	ArrayList<Student> listGrade = new ArrayList<>(listStudent.values());

	listGrade.sort((s1,s2)->{
		int compare = s2.avg - s1.avg;
		if(compare==0){
			compare = s1.submit - s2.submit;
			if(compare==0){
				compare=s1.id-s2.id;
			}
		}
		return compare;
	});

	for(Student s : listGrade){
		sb.append(s.id).append(" ").append(s.avg).append(" ").append(s.submit).append("\n");
	}
	System.out.println(sb);
   }
   
   static class Student {
    public Student(int id, int subjectNum) {
        super();
        this.id=id;
        this.subjectNum= subjectNum;
    }
	int id;
	int avg;
	int subjectNum; 
    int submit;
	int sum;

	HashMap<Integer, Integer> subjectMap = new HashMap<>();

	public void setGrade(int course, int grade){
		submit++;
		if(grade> subjectMap.getOrDefault(course, -1)){
			sum -= subjectMap.getOrDefault(course, 0);
			subjectMap.put(course, grade);
			sum += grade;
		}
		this.avg = sum/subjectNum;
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
