public class Records {
    String typeCake;
    int numTiers;
    String eventDay;

    public String getTypeCake() {
        return typeCake;
    }

    public void setTypeCake(String typeCake) {
        this.typeCake = typeCake;
    }

    public int getNumTiers() {
        return numTiers;
    }

    public void setNumTiers(int numTiers) {
        this.numTiers = numTiers;
    }

    public String getEventDay() {
        return eventDay;
    }

    public void setEventDay(String eventDay) {
        this.eventDay = eventDay;
    }

    @Override
    public String toString() {
        return "typeCake: " + typeCake + ", numTiers: " + numTiers + ", eventDay: " + eventDay;
    }

    
}
