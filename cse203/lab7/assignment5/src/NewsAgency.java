
public class NewsAgency extends Subject {

    public void publishNews(String news) {
        notifyObservers(news);
    }
}
