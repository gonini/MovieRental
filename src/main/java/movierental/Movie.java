package movierental;

class Movie {

    private String title;
    private PriceStrategy priceStrategy;

    public Movie(String title, PriceStrategy priceStrategy) {
        this.title = title;
        this.priceStrategy = priceStrategy;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice(int daysRented) {
        return priceStrategy.getPrice(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if ((priceStrategy instanceof NewReleasePrice) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}