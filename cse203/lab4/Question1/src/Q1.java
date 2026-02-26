
public class Q1 {

    public static void main(String[] args) {

        // user nhập sai và nhập lại
        // Scanner sc = new Scanner(System.in);
        // String number;
        // while(true){
        //     number = sc.next();
        //     if(checkNumber(number)){
        //         break;
        //     }
        //     else{
        //         System.out.println("nhap lai number: ");
        //     }
        // }
        
        String number = "123-L";
        if (checkNumber(number)) {
            Employee employee = new Employee("a", number, "13/11/2024");
            ProductionWorker productionWorker = new ProductionWorker(employee);
            productionWorker.addInformation(1, 10);
            System.out.println(productionWorker);
        }
        else{
            System.out.println("error number");
        }

    }

    static boolean checkNumber(String number) {
        if (number.length() != 5) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) < '0' || number.charAt(i) > '9') {
                return false;
            }
        }
        if (!String.valueOf(number.charAt(3)).equals("-")) {
            return false;
        }
        if (number.charAt(4) < 'A' || number.charAt(4) > 'M') {
            return false;
        }
        return true;
    }
}
