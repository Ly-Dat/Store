public class Essay5 extends GradedActivity5{
    double grammar;
    double spelling;
    double correctLength;
    double content;
    GradedActivity5 gradedActivity = new GradedActivity5();
    public Essay5(double grammar, double spelling, double correctLength, double content){
        this.grammar = grammar;
        this.spelling = spelling;
        this.correctLength = correctLength;
        this.content = content;
        double point = grammar+spelling+correctLength+content;
        gradedActivity.setScore(point);
    }
    public double getScore(){
        return gradedActivity.getScore();
    }
    public char getGrade(){
        return gradedActivity.getGrade();
    }

    @Override
    public String toString() {
        return "students essay score: "+ getScore() + ", grade: "+ getGrade();
    }


    

}
