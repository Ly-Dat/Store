public class ProductionWorker {
    int shift;
    double hourlyPayRate;
    Employee employee;

    public ProductionWorker(Employee employee) {
        this.employee = employee;
    }

    public void addInformation(int shift, double hourlyPayRate) {
        this.shift = shift;
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public String toString() {
        return  employee +"\n"+ "shift: " + shift + ", hourly pay rate: " + hourlyPayRate;
    }

    

}
