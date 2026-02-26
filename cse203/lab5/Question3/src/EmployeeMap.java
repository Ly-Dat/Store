import java.util.HashMap;

public class EmployeeMap {
    private HashMap<String, Employee> map;

    public EmployeeMap() {
        this.map = new HashMap<>();
    }
    public void add(Employee employee) {
        this.map.put(employee.getIdNumber(), employee);
    }
    public String get(String id){
        if(map.get(id)==null){
            return "id: "+id+", can not find";
        }
        return map.get(id).toString()+", has found";
    }

}
