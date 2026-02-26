public class Q2 {
    public static void main(String[] args) {
        Instructor instructor1 = new Instructor("123", "a");
        Instructor instructor2 = new Instructor("124", "b");
        Instructor instructor3 = new Instructor("125", "c");
        InstructorSet instructorSet = new InstructorSet();
        instructorSet.add(instructor1);
        instructorSet.add(instructor2);
        System.out.println(instructorSet.search(instructor3));
        System.out.println(instructorSet.search(instructor2));
        System.out.println("- All Instructor in set: ");
        System.out.println(instructorSet);

    }
}
