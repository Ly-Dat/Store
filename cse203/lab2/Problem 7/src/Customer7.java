public class Customer7 {
    String name;
    String adrress;
    String licenseNumber;
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
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String phoneNumber) {
        this.licenseNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return "name: " + name + ", adrress: " + adrress + ", license number: " + licenseNumber;
    }
    
}
