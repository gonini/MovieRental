package movierental;

public class NewReleaseSettlement extends Settlement {

    private static final int DEFAULT_PRICE = 3;

    @Override
    public double getPrice(int daysRented) {
        return daysRented * DEFAULT_PRICE;
    }

    @Override
    public int getFrequentPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
