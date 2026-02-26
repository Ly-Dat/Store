package design_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private List<Observer> observers;

    public Topic() {
        observers = new ArrayList<>();
    }

    public void subscribe(Observer a){
        observers.add(a);
    }
    public void unsubscribe(Observer a){
        observers.remove(a);
    }

    public void notify(String message){
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

        
}
