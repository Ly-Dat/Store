public class PushNotificationService implements INotificationService{
    public void send(String message){
        System.out.println("message: \""+message+"\" has sended by Notification");
    }
}
