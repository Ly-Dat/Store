package abstract_demo;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        // ArrayList<Student> students = new ArrayList<>();
        // RichStudent r = new RichStudent("A", 0, 1000000);
        // students.add(r);//ko báo lỗi do tính đa hình




        // Student s = new RichStudent("A", 0, 1000000);
        // s.diHoc(); // in ra????
        // s = new SuperRichStudent("B", 0, 1000000000);
        // s.diHoc();// in ra????
        Calc2 calc2 = new Calc2Implementation(); // do tính đa hình
        System.out.println(calc2.calc(4, 5));

        Calc2 calc22 = (a,b) -> a+b; // bieu thuc lambda
        System.out.println(calc22.calc(45, 5));

        Print p = () -> {
            System.out.println("hello");
            System.out.println("ahihi");
        };
        p.print();


        Calculate calculate = (x, y, z) -> {
            System.out.println("ahihi");
            return (x + y + z)*1.0/3;
        }; 
        System.out.println(calculate.calc(3, 2, 2));


    }
}
