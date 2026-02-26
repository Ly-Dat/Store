package aggregationDemo;
public class Instructor {
    private String fName;
    private String lName;
    private String office;
    private String officeHours;
    public Instructor(String fName, String lName, String office, String officeHours) {
        this.fName = fName;
        this.lName = lName;
        this.office = office;
        this.officeHours = officeHours;
    }

    
    public Instructor(Instructor aInstructor) {
        fName = aInstructor.getfName();
        lName = aInstructor.getlName();
        officeHours = aInstructor.getOfficeHours();
        office = aInstructor.getOffice();
    }


    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }
    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }
    public String getOffice() {
        return office;
    }
    public void setOffice(String office) {
        this.office = office;
    }
    public String getOfficeHours() {
        return officeHours;
    }
    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    @Override
    public String toString() {
        return "Instructor [fName=" + fName + ", lName=" + lName + ", office=" + office + ", officeHours=" + officeHours
                + "]";
    }
    
    
}
