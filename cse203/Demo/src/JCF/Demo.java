package JCF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        Student a = new Student("a", "a", 10);
        Student b = new Student("1", "b", 05);
        a.setGender(Gender.MALE);
        b.setGender(Gender.MALE);
        List<Student> students = new ArrayList<>();
        students.add(b);
        students.add(a);
        

        long count = students.stream()
                        .filter(s -> (s.getGender().equals(Gender.MALE) == false))
                        .count();
        System.out.println(count);
        
        
        
    }
}
