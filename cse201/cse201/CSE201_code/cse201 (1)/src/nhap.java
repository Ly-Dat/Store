public class nhap {

    public static void main(String[] args) {
        int a = 10, b = 6;
        System.out.println(1<<33);
        a = a ^ b;
        b = a ^ b;
        a = b ^ a;
        System.out.println("a = " + a + "\n" + "b = " + b);

    }
}
