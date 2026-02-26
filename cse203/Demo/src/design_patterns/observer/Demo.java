package design_patterns.observer;

public class Demo {
    public static void main(String[] args) {
        Observer e = new Email();
        Observer s = new SMS("0123");
        Apple apple = new Apple();
        apple.subscribe(s);
        apple.subscribe(e);
        apple.unsubscribe(s);
        apple.notify("apple has launched a new iphone!!!!!!!!!");
    }
}
