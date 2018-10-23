package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
class Rental implements ProductRental {

    private static final int LONG_TERM_RENTAL_DAYS_BY_REGULAR = 2;
    private static final int LONG_TERM_RENTAL_DAYS_BY_CHILDRENS = 3;

    private static final int DEFAULT_PRICE_BY_REGULAR = 2;
    private static final double DEFAULT_PRICE_BY_CHILDRENS = 1.5;
    private static final int DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE = 3;

    private static final double LONG_TERM_RENTAL_COST_FACTOR = 1.5;

    private Movie _movie;
    private int _daysRented;

    Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    private int getDaysRented() {
        return _daysRented;
    }

    private PriceCode getPriceCode() {
        return _movie.getPriceCode();
    }

    private String getTitle() {
        return _movie.getTitle();
    }

     Movie getMovie() {
        return _movie;
    }

    @Override
    public double getAmounts() {
            double thisAmount = 0;

            //determine amounts for each line
            switch (getPriceCode()) {
                case regular:
                    thisAmount += DEFAULT_PRICE_BY_REGULAR;
                    if (getDaysRented() > LONG_TERM_RENTAL_DAYS_BY_REGULAR)
                        thisAmount += (getDaysRented() - LONG_TERM_RENTAL_DAYS_BY_REGULAR) * LONG_TERM_RENTAL_COST_FACTOR;
                    break;
                case newRelease:
                    thisAmount += getDaysRented() * DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE;
                    break;
                case childrens:
                    thisAmount += DEFAULT_PRICE_BY_CHILDRENS;
                    if (getDaysRented() > LONG_TERM_RENTAL_DAYS_BY_CHILDRENS)
                        thisAmount += (getDaysRented() - LONG_TERM_RENTAL_DAYS_BY_CHILDRENS) * LONG_TERM_RENTAL_COST_FACTOR;
                    break;
            }
        return thisAmount;
    }

    @Override
    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;
        if ((getPriceCode() == PriceCode.newRelease) && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    @Override
    public String getFiguresForRental() {
        return "\t" + getTitle() + "\t" + String.valueOf(getAmounts()) + "\n";
    }
}
