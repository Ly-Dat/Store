public class ShiftSupervisor {
    double annualSalary;
    double annualBonus;
    Employee2 employee;

    public ShiftSupervisor(Employee2 employee) {
        this.employee = employee;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public void setAnnualBonus(double annualBonus) {
        this.annualBonus = annualBonus;
    }


    @Override
    public String toString() {
        return  employee +"\n"+ "annual salary: " + annualSalary + ", annual production bonus: " + annualBonus;
    }
}
