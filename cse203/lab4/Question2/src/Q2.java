
public class Q2 {
    public static void main(String[] args) {
        String number = "123-L";
        if (checkNumber(number)) {
            Employee2 employee = new Employee2("a", number, "13/11/2024");
            ShiftSupervisor supervisor = new ShiftSupervisor(employee);
            supervisor.setAnnualSalary(100);
            supervisor.setAnnualBonus(10);
            System.out.println(supervisor);
        }
        else{
            System.out.println("error number");
        }
        
    }
    static boolean checkNumber(String number){
        if(number.length()!=5){
            return false;
        }
        for(int i=0; i<3; i++){
            if(number.charAt(i)<'0' || number.charAt(i)>'9'){
                return false;
            }
        }
        if(!String.valueOf(number.charAt(3)).equals("-")){
            return false;
        }
        if(number.charAt(4)<'A' || number.charAt(4)>'M'){
            return false;
        }
        return true;
    }
}
