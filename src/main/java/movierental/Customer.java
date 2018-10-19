package movierental;

import java.util.ArrayList;
import java.util.List;

class Customer {

    private static final int LONG_TERM_RENTAL_DAYS_BY_REGULAR = 2;
    private static final int LONG_TERM_RENTAL_DAYS_BY_CHILDRENS = 3;

    private static final int DEFAULT_PRICE_BY_REGULAR = 2;
    private static final double DEFAULT_PRICE_BY_CHILDRENS = 1.5;
    private static final int DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE = 3;

    private static final double LONG_TERM_RENTAL_COST_FACTOR = 1.5;

    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental each: _rentals) {
            double thisAmount = 0;

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case regular:
                    thisAmount += DEFAULT_PRICE_BY_REGULAR;
                    if (each.getDaysRented() > LONG_TERM_RENTAL_DAYS_BY_REGULAR)
                        thisAmount += (each.getDaysRented() - LONG_TERM_RENTAL_DAYS_BY_REGULAR) * LONG_TERM_RENTAL_COST_FACTOR;
                    break;
                case newRelease:
                    thisAmount += each.getDaysRented() * DEFAULT_PRICE_FACTOR_BY_NEW_RELEASE;
                    break;
                case childrens:
                    thisAmount += DEFAULT_PRICE_BY_CHILDRENS;
                    if (each.getDaysRented() > LONG_TERM_RENTAL_DAYS_BY_CHILDRENS)
                        thisAmount += (each.getDaysRented() - LONG_TERM_RENTAL_DAYS_BY_CHILDRENS) * LONG_TERM_RENTAL_COST_FACTOR;
                    break;
            }

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == PriceCode.newRelease) && each.getDaysRented() > 1)
                frequentRenterPoints++;

            // show figures for this rental

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
}
