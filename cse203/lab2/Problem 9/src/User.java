public class User {
    String id;
    String name;
    String email;

    public User(String id, String name, String email) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public String getValue(){
        return id + " " + name + " " + email;
    }

}
