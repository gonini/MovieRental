package movierental;

public class ChildrenSettlement implements SettlementStrategy {

    private static final int LONG_TERM_RENTAL_DAYS_BY_CHILDRENS = 3;
    private static final double DEFAULT_PRICE_BY_CHILDRENS = 1.5;
    private static final double LONG_TERM_RENTAL_COST_FACTOR = 1.5;

    @Override
    public double getPrice(int daysRented) {
        double ret = 0.0;
        ret += DEFAULT_PRICE_BY_CHILDRENS;
        if (daysRented > LONG_TERM_RENTAL_DAYS_BY_CHILDRENS)
            ret += (daysRented - LONG_TERM_RENTAL_DAYS_BY_CHILDRENS) * LONG_TERM_RENTAL_COST_FACTOR;
        return ret;
    }

    @Override
    public int getFrequentPoints(int daysRented) {
        return 1;
    }
}
