

public class Q3 {

    public static void main(String[] args) {
        String number = "123-L";
        if (checkNumber(number)) {
            Employee3 employee = new Employee3("a", number, "13/11/2024");
            ProductionWorker3 productionWorker = new ProductionWorker3(employee);
            productionWorker.addInformation(1, 10);
            TeamLeader teamLeader = new TeamLeader(productionWorker);
            teamLeader.setMonthlyBonus(50);
            teamLeader.setRequiredTrainingHours(2);
            teamLeader.setTrainingHours(3);
            System.out.println(teamLeader);
        } else {
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
