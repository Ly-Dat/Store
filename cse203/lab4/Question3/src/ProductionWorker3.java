public class ProductionWorker3 {
    int shift=0;
    double hourlyPayRate=0;
    Employee3 employee;

    public ProductionWorker3(Employee3 employee) {
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
