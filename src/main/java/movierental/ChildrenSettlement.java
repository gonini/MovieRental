package movierental;

public class ChildrenSettlement extends Settlement {

    private static final int LONG_TERM_RENTAL_DAYS_BY_CHILDRENS = 3;
    private static final double DEFAULT_PRICE_WITH_CHILDRENS = 1.5;

    @Override
    public double getPrice(int daysRented) {
        return DEFAULT_PRICE_WITH_CHILDRENS +
                getLongTermRentalCosts(
                        daysRented,
                        LONG_TERM_RENTAL_DAYS_BY_CHILDRENS,
                        DEFAULT_PRICE_WITH_CHILDRENS
                );
    }
}
