
public class ShoesServicesTicket {

    private int ticketID;
    private String customerName;
    private String brand;
    private String model;
    private String color;
    private String type;
    private float laborPrice;
    private String services;
    private float voucher;
    public ShoesServicesTicket() {
        this.ticketID = 0;
        this.customerName = "";
        this.brand = "";
        this.model = "";
        this.color = "";
        this.type = "";
        this.laborPrice = 0;
        this.services = "";
        this.voucher = 0;
    }
    public ShoesServicesTicket(int ticketID, String customerName, String brand, String model, String color, String type,
            float laborPrice, String services, float voucher) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.type = type;
        this.laborPrice = laborPrice;
        this.services = services;
        this.voucher = voucher;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLaborPrice(float laborPrice) {
        this.laborPrice = laborPrice;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setVoucher(float voucher) {
        this.voucher = voucher;
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public float getLaborPrice() {
        return laborPrice;
    }

    public String getServices() {
        return services;
    }

    public float getVoucher() {
        return voucher;
    }
    public float getPayment() {
        float servicePrice = 0;
        if (services.contains("Washing")) {
            servicePrice += 5;
        }
        if (services.contains("Renew Upper")) {
            servicePrice += 10;
        }
        if (services.contains("Renew Sole")) {
            servicePrice += 15;
        }
        if (services.contains("Repair")) {
            servicePrice += 20;
        }
        if (services.contains("Custom Paint")) {
            servicePrice += 40;
        }

        float payment;
        switch (type) {
            case "Sandals":
                payment = laborPrice + servicePrice;
                break;
            case "Sneakers":
                payment = laborPrice * 1.5f + servicePrice;
                break;
            case "Leather Shoes":
                payment = laborPrice * 2 + servicePrice;
                break;
            default:
                throw new IllegalArgumentException("Invalid shoe type: " + type);
        }

        payment -= voucher;
        return payment;
    }

}
