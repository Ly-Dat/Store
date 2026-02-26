public class Q6_7 {
    public static void main(String[] args) {
        MyList myListI = new MyList<>();
        myListI.add(2);
        myListI.add(5);
        myListI.add(3);
        myListI.add(1);
        System.out.println(myListI.getLargest());
        //


        MyListModification myListS = new MyListModification<>();
        myListS.add("A");
        myListS.add("b");
        myListS.add("C");
        myListS.add("a");
        System.out.println(myListS.getSmallest());
        
    }
}
