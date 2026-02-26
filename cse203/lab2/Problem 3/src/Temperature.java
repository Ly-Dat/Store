public class Temperature {
    double ftemp;

    public double getFtemp() {
        return ftemp;
    }

    public void setFtemp(double ftemp) {
        this.ftemp = ftemp;
    }
    public double getCelsius() {
        double c = (ftemp-32)/1.8;
        return c;
    }
    public double getKelvin() {
        double k = (ftemp-32)/1.8 + 273;
        return k;
    }
    

}
