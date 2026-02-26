
import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> list;

    public Subject() {
        this.list = new ArrayList<>();
    }
    public void addObserver(Observer observer){
        list.add(observer);
    }
    public void removeObserver(Observer observer){
        list.remove(observer);
    }
    public void notifyObservers(String message){
        for (var t : list) {
            t.update(message);
        }
    }
    
}
