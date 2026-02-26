package design_patterns.observer;

public class SMS implements Observer{
    private String phoneNumber;

    public SMS(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String s) {
        System.out.println("Update" + s + " through sms" + phoneNumber);
    }
}
