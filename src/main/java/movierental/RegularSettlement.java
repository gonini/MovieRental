package movierental;

public class RegularSettlement extends Settlement {

    private static final int LONG_TERM_RENTAL_DAYS = 2;
    private static final int DEFAULT_PRICE_BY_REGULAR = 2;
    private static final double LONG_TERM_RENTAL_COST = 1.5;

    @Override
    public double getPrice(int daysRented) {
        return DEFAULT_PRICE_BY_REGULAR +
                getLongTermRentalCosts(
                        daysRented,
                        LONG_TERM_RENTAL_DAYS,
                        LONG_TERM_RENTAL_COST
                );
    }
}
