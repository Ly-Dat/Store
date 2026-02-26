public class HotelDemo {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel();
        StandardRoom standardRoom1 = new StandardRoom("101", 100.0, 2);
        StandardRoom standardRoom2 = new StandardRoom("102", 120.0, 1);
        SuiteRoom suiteRoom1 = new SuiteRoom("201", 300.0);
        suiteRoom1.addSuit("living room");
        suiteRoom1.addSuit("kitchen");

        hotel.addRoom(standardRoom1);
        hotel.addRoom(standardRoom2);
        hotel.addRoom(suiteRoom1);
        hotel.listRooms();

        System.out.println("reserver: ");
        hotel.reserveRoom("101");
        hotel.reserveRoom("201");
        hotel.listRooms();

        System.out.println("release: ");
        hotel.release("101");
        hotel.listRooms();

        System.out.println("remove: ");
        hotel.removeRoom("101");
        hotel.listRooms();
    }
}
