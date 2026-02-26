public class Q5_6 {
    public static void main(String[] args){
        CourseGrades course = new CourseGrades();

        GradedActivity5 lab = new GradedActivity5();
        lab.setScore(85);
        course.setLab(lab);

        PassFailExam passFailExam = new PassFailExam(10, 0, 70);
        passFailExam.setScore(75);
        course.setPassFailExam(passFailExam);

        Essay5 essay = new Essay5(25, 18, 20, 28);
        course.setEssay(essay);

        FinalExam finalExam = new FinalExam(50, 0);
        finalExam.setScore(92);
        course.setFinalExam(finalExam);
        
        
        System.out.println(course.toString());
    }
    public interface Analyzable{
        double getAverage();
        GradedActivity5 getHighest();
        GradedActivity5 getLowest();
    }
}

