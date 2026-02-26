public class SMSSubscriber implements Observer{
    @Override
    public void update(String message) {
        System.out.println("SMS Subscriber: "+message);
    }
}
