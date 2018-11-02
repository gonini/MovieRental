package movierental;

public class NewReleaseSettlement extends Settlement {

    private static final int DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE = 3;

    @Override
    public double getPrice(int daysRented) {
        return daysRented * DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE;
    }

    @Override
    public int getFrequentPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
