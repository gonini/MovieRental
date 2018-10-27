package movierental;

public class NewReleaseSettlement implements SettlementStrategy {

    private static final int DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE = 3;

    @Override
    public double getPrice(int daysRented) {
        double ret = 0.0;
        ret += daysRented * DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE;
        return ret;
    }

    @Override
    public int getFrequentPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
