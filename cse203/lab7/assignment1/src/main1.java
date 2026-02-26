public class main1 {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("first log");

        Logger logger2 = Logger.getInstance();
        logger2.log("second log");

        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the same instance.");
        } else {
            System.out.println("logger1 and logger2 are different instances.");
        }
    }
}
