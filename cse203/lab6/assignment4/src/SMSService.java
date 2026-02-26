public class SMSService implements INotificationService {
    public void send(String message){
        System.out.println("message: \""+message+"\" has sended by SMS");
    }
}
