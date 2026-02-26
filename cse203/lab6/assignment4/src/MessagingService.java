public class MessagingService {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.sendEmail("hi");
        manager.sendSMS("hello");
        manager.sendPushNotification("hmmm");
    }
}
