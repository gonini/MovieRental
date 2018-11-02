package movierental;

public class ChildrenSettlement extends Settlement {

    private static final int LONG_TERM_RENTAL_DAYS = 3;
    private static final double DEFAULT_PRICE = 1.5;
    private static final double LONG_TERM_RENTAL_COST = 1.5;

    @Override
    public double getPrice(int daysRented) {
        return DEFAULT_PRICE +
                getLongTermRentalCosts(
                        daysRented,
                        LONG_TERM_RENTAL_DAYS,
                        LONG_TERM_RENTAL_COST
                );
    }

}
