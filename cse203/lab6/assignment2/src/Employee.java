public abstract class Employee {
    private String name;
    public Employee(String name) {
        this.name = name;
    }
    public abstract double calculatePay();

    @Override
    public String toString() {
        return name+" "+calculatePay();
    }

}
