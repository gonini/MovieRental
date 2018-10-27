package movierental;

public class RegularSettlement implements SettlementStrategy {

    private static final int LONG_TERM_RENTAL_DAYS_BY_REGULAR = 2;
    private static final int DEFAULT_PRICE_BY_REGULAR = 2;
    private static final double LONG_TERM_RENTAL_COST_FACTOR = 1.5;

    @Override
    public double getPrice(int daysRented) {
        double ret = 0.0;
        ret += DEFAULT_PRICE_BY_REGULAR;
        if (daysRented > LONG_TERM_RENTAL_DAYS_BY_REGULAR)
            ret += (daysRented - LONG_TERM_RENTAL_DAYS_BY_REGULAR) * LONG_TERM_RENTAL_COST_FACTOR;
        return ret;
    }

    @Override
    public int getFrequentPoints(int daysRented) {
        return 1;
    }
}
