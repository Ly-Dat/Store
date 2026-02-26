public class Customer8 {
    String name;
    String adrress;
    String phoneNumber;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAdrress() {
        return adrress;
    }
    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "name: " + name + ", adrress: " + adrress + ", phoneNumber: " + phoneNumber;
    }
    
}
