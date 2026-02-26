package inheritance;

public class GradedActivity {
    private double score;

    public GradedActivity() {
        this.score = 0;
    }
    
    public int chayXe(){
        return 40;
    }
    
    
    public GradedActivity(int i) {
        score = i;
    }


    public double getScore() {
        return score;
    }

    

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "GradedActivity [score=" + score + "]";
    }

    
    
    
}