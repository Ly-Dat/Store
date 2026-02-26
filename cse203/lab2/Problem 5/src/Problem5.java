public class Problem5 {
    public static void main(String[] args) {
        Customer5 customer = new Customer5();
        customer.setName("a");
        customer.setAdrress("123/1 binh duong");
        customer.setPhoneNumber("0912345678");
        Pet pet = new Pet();
        pet.setBreek(10);
        pet.setAge(5);
        pet.setWeight(6);

        double tax=0.1;
        ServiceEstimate serviceEstimate = new ServiceEstimate(tax);
        serviceEstimate.setGroomingCost(100);
        serviceEstimate.setCareCharges(10);
        
        System.out.println(customer.toString());
        System.out.println(pet.toString());
        System.out.println("total money: ");
        System.out.println(serviceEstimate.getTotal());

    }

}
