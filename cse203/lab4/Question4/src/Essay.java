public class Essay {
    double grammar;
    double spelling;
    double correctLength;
    double content;
    GradedActivity gradedActivity = new GradedActivity();
    public Essay(double grammar, double spelling, double correctLength, double content) {
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
