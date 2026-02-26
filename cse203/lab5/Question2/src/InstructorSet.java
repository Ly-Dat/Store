import java.util.HashSet;

public class InstructorSet {
    private HashSet<Instructor> set;
    
    public InstructorSet() {
        this.set = new HashSet<>();
    }
    public void add(Instructor instructor){
        set.add(instructor);
    }
    public String search(Instructor instructor){
        StringBuilder sb = new StringBuilder();
        sb.append(instructor+" : ");
        if(set.contains(instructor)){
            sb.append("has in set");
        }
        else{
            sb.append("no contains");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        set.forEach(p->sb.append(p).append("\n"));
        return sb.toString();
    }
    
}
