public class Employee2 {
    String name;
    String number;
    String hireDate;

    public Employee2(String name, String number, String hireDate) {
        this.hireDate = hireDate;
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "name: " + name + ", number: " + number + ", hire date: " + hireDate;
    }
    

}
