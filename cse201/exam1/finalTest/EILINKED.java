
import java.util.Currency;
import java.util.Scanner;

public class EILINKED<T extends Number> {

    static private class LinkedNode<U extends Number> {

        U number;
        LinkedNode<U> next;

        public LinkedNode(U number) {
            this.number = number;
        }
    }

    private LinkedNode<T> head = null;
    private int size =0;

    private int compare(T n1, T n2) {
        long l1 = n1.longValue();
        long l2 = n2.longValue();
        if (l1 != l2) {
            return (l1 < l2 ? -1 : 1);
        }
        return Double.compare(n1.doubleValue(), n2.doubleValue());
    }

    

    public int size() {
        return size;
    }

    public void add(T number) {
        LinkedNode<T> newNode = new LinkedNode<>(number);
        if(head==null){
            head=newNode;
        }
        else{
            LinkedNode<T> now = head;
            while(now.next != null){
                now = now.next;
            }
        }
        size++;
    }

    /**
     * @return -1 if number is not in list
     */
    public int firstIndexOf(T number) {
        LinkedNode<T> now = head;
        int vt =0;
        while(now != null){
            if(now.number.equals(number)){
                return vt;
            }
            now = now.next;
            vt++;
        }
        return -1;
    }

    /**
     * @return -1 if number is not in list
     */
    public int lastIndexOf(T number) {
        LinkedNode<T> now = head;
        int vt =0;
        int lastIndex = -1;
        while(now != null){
            if(now.number.equals(number)){
                lastIndex = vt;
            }
            now = now.next;
            vt++;
        }
        return lastIndex;
    }

    /**
     * Remove first occurence of number
     */
    public void removeFirst(T number) {
        if(head == null){
            return;
        }

        if(head.number.equals(number)){
            head = head.next;
            size--;
            return;
        }
        
        LinkedNode<T> now = head;

        while(now.next!= null && !now.next.number.equals(number)){
            now = now.next;
        }
        if (now.next != null) {
            now.next = now.next.next;
            size--;
        }

    }

    public void removeAt(int index) {
        if (index < 0 || index >= size){
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            LinkedNode<T> now = head;
            for (int i = 0; i < index - 1; i++) {
                now = now.next;
            }
            now.next = now.next.next;
        }
        size--;
    }

    public void insertAt(int index, T number) {
        if (index < 0 || index >= size){
            return;
        }
        LinkedNode<T> newNode = new LinkedNode<>(number);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else{
            LinkedNode<T> now = head;
            for (int i = 0; i < index - 1; i++) {
                now = now.next;
            }
            newNode.next = now.next;
            now.next = newNode;
        }
        size++;
    }

    /**
     * @return null if index is out of range
     */
    public T getAt(int index) {
        if (index < 0 || index >= size){
            return null;
        } 
        
        LinkedNode<T> now = head;
        for (int i = 0; i < index; i++) {
            now = now.next;
        }
        return now.number;
    }

    public double sum() {
        double sum =0;
        LinkedNode<T> now = head;
        while(now != null){
            sum+=now.number.doubleValue();
            now = now.next;
        }
        return sum;
    }

    public double average() {
        if(size == 0){
            return 0;
        }
        return sum()/size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EILINKED<Integer> linkedList = new EILINKED<Integer>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            linkedList.add(sc.nextInt());
        }
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String command = sc.next();
            switch (command) {
                case "size":
                    System.out.println(linkedList.size());
                    break;
                case "sum":
                    System.out.println(linkedList.sum());
                    break;
                case "average":
                    System.out.println(linkedList.average());
                    break;
                case "getAt":
                    int index = sc.nextInt();
                    System.out.println(linkedList.getAt(index));
                    break;
                case "firstIndexOf":
                    int value1 = sc.nextInt();
                    System.out.println(linkedList.firstIndexOf(value1));
                    break;
                case "lastIndexOf":
                    int value2 = sc.nextInt();
                    System.out.println(linkedList.lastIndexOf(value2));
                    break;
                case "add":
                    int value3 = sc.nextInt();
                    linkedList.add(value3);
                    break;
                case "removeFirst":
                    int value4 = sc.nextInt();
                    linkedList.removeFirst(value4);
                    break;
                case "removeAt":
                    int idx = sc.nextInt();
                    linkedList.removeAt(idx);
                    break;
                case "insertAt":
                    int idx2 = sc.nextInt();
                    int value5 = sc.nextInt();
                    linkedList.insertAt(idx2, value5);
                    break;
                default:
                    break;
            }
            sc.nextLine();
        }
    }
}
