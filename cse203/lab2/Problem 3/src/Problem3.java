public class Problem3 {
    public static void main(String[] args) {
        Temperature temperature = new Temperature();
        temperature.setFtemp(12.5);
        System.out.println("Celsius: "+temperature.getCelsius()+", Kelvin: "+temperature.getKelvin());
    }
}
