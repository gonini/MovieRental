package movierental;

import java.util.LinkedList;
import java.util.List;

public class Rentals {

    private List<Rental> rentals = new LinkedList<>();

    public void add(Rental rental) {
        if(rental == null) {
            throw new IllegalArgumentException();
        }
        rentals.add(rental);
    }

    public String getRentalInfo(String name) {
        return getHeader(name) +
                getText() +
                getFooter();
    }

    private double getAmounts() {
         return rentals.stream()
                .mapToDouble(Rental::getAmounts)
                .sum();
    }

    private int getFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }

    private String getFiguresForRental() {
        return rentals.stream()
                .map(Rental::getFiguresForRental)
                .reduce("", (figuresA, figuresB) -> figuresA + figuresB);
    }

    private String getHeader(String name) {
        return "Rental Record for " + name + "\n";
    }

    private String getText() {
        return getFiguresForRental();
    }

    private String getFooter() {
        return "Amount owed is " + String.valueOf(getAmounts()) + "\n" +
                "You earned " + String.valueOf(getFrequentRenterPoints()) +
                " frequent renter points";
    }
}


