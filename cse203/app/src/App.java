public class App {
    public static void main(String[] args) throws Exception {
        Student[] student = new Student[3];
        
        for(int i=1; i<4; i++){
            student[i-1] = new Student("Student "+i, 10*i);
            
        }
        // Student max = student[0];
        // for(int i=1; i<student.length; i++){
        //     if(max.getScore() < student[i].getScore()){
        //         max=student[i];
        //     }
        // }


        Student min = student[0];
        for(int i=1; i<student.length; i++){
            if(min.getName().compareTo(student[i].getName()) < 0){
                min=student[i];
            }
        }
        System.out.println(min);
        
    }
}
