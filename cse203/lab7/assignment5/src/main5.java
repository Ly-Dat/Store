public class main5 {
    public static void main(String[] args) throws Exception {
        NewsAgency agency = new NewsAgency();

        Observer emailSubscriber = new EmailSubscriber();
        Observer smsSubscriber = new SMSSubscriber();

        agency.addObserver(emailSubscriber);
        agency.addObserver(smsSubscriber);

        agency.publishNews("Breaking News!");
    }
}
