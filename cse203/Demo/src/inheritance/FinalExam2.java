package inheritance;

public class FinalExam2 extends FinalExam{
    private String time;

    public FinalExam2(int i, int numberOfQuestions, int numberOfRightQuestions, String time) {
        super(i, numberOfQuestions, numberOfRightQuestions);
        this.time = time;
    }
    
}
