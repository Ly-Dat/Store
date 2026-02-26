package design_patterns.observer;

public class Email implements Observer{
    
    @Override
    public void update(String s) {
        System.out.println("Update" + s + " through email");
    }
    
}
