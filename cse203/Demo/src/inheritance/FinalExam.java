package inheritance;

public class FinalExam extends GradedActivity{
    private int numberOfQuestions;
    private int numberOfRightQuestions;
    private final double MAX_SCORE = 100;
    public FinalExam(int i, int numberOfQuestions, int numberOfRightQuestions) {
        super(i);
        this.numberOfQuestions = numberOfQuestions;
        this.numberOfRightQuestions = numberOfRightQuestions;
    }
    // overloading
    public void setScore(int score){

    }

    public void print()
    {
        System.out.println("hello");
    }
    // overloading
    public void setScore(short score){

    }
    @Override
    public int chayXe(){
        return 120;
    }


    
    
}
