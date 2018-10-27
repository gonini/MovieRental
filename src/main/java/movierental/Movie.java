package movierental;

class Movie {

    private static final int LONG_TERM_RENTAL_DAYS_BY_REGULAR = 2;
    private static final int LONG_TERM_RENTAL_DAYS_BY_CHILDRENS = 3;

    private static final int DEFAULT_PRICE_BY_REGULAR = 2;
    private static final double DEFAULT_PRICE_BY_CHILDRENS = 1.5;
    private static final int DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE = 3;

    private static final double LONG_TERM_RENTAL_COST_FACTOR = 1.5;


    private String _title;
    private PriceCode _priceCode;

    public Movie(String title, PriceCode priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        _priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public double getPrice(int daysRented) {
        double price = 0;

        //determine amounts for each line
        switch (getPriceCode()) {
            case regular:
                price += DEFAULT_PRICE_BY_REGULAR;
                if (daysRented > LONG_TERM_RENTAL_DAYS_BY_REGULAR)
                    price += (daysRented - LONG_TERM_RENTAL_DAYS_BY_REGULAR) * LONG_TERM_RENTAL_COST_FACTOR;
                break;
            case newRelease:
                price += daysRented * DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE;
                break;
            case childrens:
                price += DEFAULT_PRICE_BY_CHILDRENS;
                if (daysRented > LONG_TERM_RENTAL_DAYS_BY_CHILDRENS)
                    price += (daysRented - LONG_TERM_RENTAL_DAYS_BY_CHILDRENS) * LONG_TERM_RENTAL_COST_FACTOR;
                break;
        }
        return price;
    }


    public int getFrequentRenterPoints(int daysRented) {
        int frequentRenterPoints = 1;
        if ((getPriceCode() == PriceCode.newRelease) && daysRented > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}