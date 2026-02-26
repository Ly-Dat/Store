public class EmailSubscriber implements Observer{

    @Override
    public void update(String message) {
        System.out.println("Email Subscriber: "+message);
    }
    
}
