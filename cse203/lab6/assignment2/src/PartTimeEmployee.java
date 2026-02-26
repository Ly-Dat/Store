public class PartTimeEmployee extends Employee{
    private int hour;
    private double moneyPerHour;
    public PartTimeEmployee(String name, int hour, double moneyPerHour) {
        super(name);
        this.hour = hour;
        this.moneyPerHour = moneyPerHour;
    }
    
    public double calculatePay(){
        return hour*moneyPerHour;
    }
}
