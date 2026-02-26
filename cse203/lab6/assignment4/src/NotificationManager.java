public class NotificationManager {
    private INotificationService inot;

    public NotificationManager() {

    }
    public void sendEmail(String message){
        this.inot = new EmailService();
        inot.send(message);
    }
    public void sendSMS(String message){
        this.inot = new SMSService();
        inot.send(message);
    }
    public void sendPushNotification(String message){
        this.inot = new PushNotificationService();
        inot.send(message);
    }
}
