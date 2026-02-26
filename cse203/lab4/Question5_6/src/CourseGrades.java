
public class CourseGrades implements Analyzable {

    GradedActivity5[] grades = new GradedActivity5[4];

    public void setLab(GradedActivity5 grade) {
        grades[0] = grade;
    }

    public void setPassFailExam(PassFailExam pfe) {
        grades[1] = pfe;
    }

    public void setEssay(Essay5 essay) {
        grades[2] = essay;
    }

    public void setFinalExam(FinalExam fe) {
        grades[3] = fe;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Lab Activity Score: " + grades[0].getScore() + " Grade: " + grades[0].getGrade() + "\n");
        result.append("Pass/Fail Exam Score: " + grades[1].getScore() + " Grade: " + grades[1].getGrade() + "\n");
        result.append("Essay Score: " + grades[2].getScore() + " Grade: " + grades[2].getGrade() + "\n");
        result.append("Final Exam Score: " + grades[3].getScore() + " Grade: " + grades[3].getGrade() + "\n");
        result.append("average: " + getAverage() + ", highest: " + getHighest().getScore() + ", lowest: " + getLowest().getScore());
        return result.toString();
    }

    @Override
    public double getAverage() {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i].getScore();
        }
        return sum / grades.length;
    }

    @Override
    public GradedActivity5 getHighest() {
        GradedActivity5 max = grades[0];
        for (var t : grades) {
            if (Double.compare(t.getScore(), max.getScore()) > 0) {
                max = t;
            }
        }
        return max;
    }

    @Override
    public GradedActivity5 getLowest() {
        GradedActivity5 min = grades[0];
        for (var t : grades) {
            if (Double.compare(t.getScore(), min.getScore()) < 0) {
                min = t;
            }
        }
        return min;
    }
}
