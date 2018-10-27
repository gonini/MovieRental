package movierental;

class Movie {

    private String title;
    private SettlementStrategy settlement;

    public Movie(String title, SettlementStrategy settlement) {
        this.title = title;
        this.settlement = settlement;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice(int daysRented) {
        return settlement.getPrice(daysRented);
    }

    public int getFrequentPoints(int daysRented) {
        return settlement.getFrequentPoints(daysRented);
    }
}