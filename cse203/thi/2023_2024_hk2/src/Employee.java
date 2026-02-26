public class Employee extends Person{
    private double monthlyIncome;
    private int numDependents;
    private final long[] income = {0, 5000000, 10000000, 18000000, 32000000, 52000000, 80000000};
    private final double[] rate = {0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35};
    
    public Employee(String name, int age, String address, long number, String email, double monthlyIncome,
            int numDependents) {
        super(name, age, address, number, email);
        this.monthlyIncome = monthlyIncome;
        this.numDependents = numDependents;
    }

    @Override
    double calculateIncomeTax() {
        double tax=0;
        double taxableIncome = monthlyIncome - numDependents*4400000;
        for(int i=0; i<income.length; i++){
            if(taxableIncome>=income[i]){
                tax = rate[i];
            }
            else{
                break;
            }
        }
        return taxableIncome*tax;
    }
    
    
}
