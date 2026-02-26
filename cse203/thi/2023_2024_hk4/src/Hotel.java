
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    private HashMap<String,Room> listRoom;

    public Hotel() {
        this.listRoom = new HashMap<>();
    }
    
    public void addRoom(Room room){
        listRoom.put(room.getID(),room);
    }
    public void removeRoom(String id){
        listRoom.remove(id);
    }
    public void reserveRoom(String id){

        if(listRoom.containsKey(id)){
            Room room = listRoom.get(id);
            if(!room.getStatus()){
                room.setStatus(true);
                System.out.println("Room " + room.getID() + " reserved.");
            }
            else{
                System.out.println("Room " + room.getID() + " is already occupied.");
            }
        }
        else{
            System.out.println("wrong room");
        }
    }
    public void release(String id){
        if(listRoom.containsKey(id)){
            Room room = listRoom.get(id);
            if(room.getStatus()){
                room.setStatus(false);
                System.out.println("Room " + room.getID() + " released.");
            }
            else{
                System.out.println("Room " + room.getID() + " is not occupied.");
            }
        }
        else{
            System.out.println("wrong room");
        }
    }
    public Room search(String id){
        return listRoom.get(id);
    }

    public ArrayList<Room> getListRoom() {
        return new ArrayList<>(listRoom.values());
    }
    public void listRooms() {
        if (listRoom.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        for (Room room : listRoom.values()) {
            System.out.println(room);
        }
    }
}