public abstract class Person {
    private String name;
    private int age;
    private String address;
    private long number;
    private String email;
    public Person(String name, int age, String address, long number, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.number = number;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getNumber() {
        return number;
    }
    public void setNumber(long number) {
        this.number = number;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    abstract double calculateIncomeTax();
}
