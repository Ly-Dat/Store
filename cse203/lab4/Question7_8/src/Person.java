public class Person {
    String name;
    String address;
    String phoneNumber;
    public Person(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "name=: " + name + ", address: " + address + ", phoneNumber: " + phoneNumber+"\n";
    }
    
}
