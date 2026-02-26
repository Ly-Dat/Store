import java.util.ArrayList;

public class MyList<T extends Number> {
    private ArrayList<T> arr;

    public MyList() {
        this.arr = new ArrayList<T>();
    }
    public void add(T value){
        arr.add(value);
    }
    public T getLargest(){
        T max = arr.get(0);
        for(T t : arr){
            if(t.doubleValue()>max.doubleValue()){
                max=t;
            }
        }
        return max;
    }
    public T getSmallest(){
        T min = arr.get(0);
        for(T t : arr){
            if(t.doubleValue()<min.doubleValue()){
                min=t;
            }
        }
        return min;
    }
    
}
