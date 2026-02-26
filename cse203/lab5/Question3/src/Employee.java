public class Employee {
    private String idNumber;
    private String name;

    public Employee(String idNumber, String name) {
        this.idNumber = idNumber;
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id number: "+idNumber+" , name: "+name;
    }

}
