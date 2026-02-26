public class TeamLeader {
    double monthlyBonus;
    int requiredTrainingHours;
    int trainingHours;
    ProductionWorker3 productionWorker;

    public TeamLeader(ProductionWorker3 productionWorker) {
        this.productionWorker = productionWorker;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    public void setRequiredTrainingHours(int requiredTrainingHours) {
        this.requiredTrainingHours = requiredTrainingHours;
    }

    public void setTrainingHours(int trainingHours) {
        this.trainingHours = trainingHours;
    }

    @Override
    public String toString() {
        return productionWorker+ "\n" + "monthly bonus= " + monthlyBonus + ", required training hours= " + requiredTrainingHours
                + ", training hours=" + trainingHours ;
    }

    

}
