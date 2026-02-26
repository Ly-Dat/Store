import java.util.ArrayList;
import java.util.Collections;

public class MyListModification<T extends Comparable<T>> {
    private ArrayList<T> arr;

    public MyListModification() {
        this.arr = new ArrayList<T>();
    }
    public void add(T value){
        arr.add(value);
    }
    public T getLargest(){
        if (arr.isEmpty()) {
            throw new IllegalStateException("List is empty, no largest element.");
        }
        return Collections.max(arr);
    }
    public T getSmallest(){
        if (arr.isEmpty()) {
            throw new IllegalStateException("List is empty, no smallest element.");
        }
        return Collections.min(arr);
    }
    
}
