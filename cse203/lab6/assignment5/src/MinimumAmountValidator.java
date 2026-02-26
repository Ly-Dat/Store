public class MinimumAmountValidator implements OrderValidation{
    static double minValidator;

    public MinimumAmountValidator(double minValidator) {
        this.minValidator = minValidator;
    }

    public boolean validate(Order order){
        if(order.getTotalAmount()<minValidator || 
        !order.getItems().contains(order.getNameItem())){
            return false;
        }
        return true;
    }
    
}
