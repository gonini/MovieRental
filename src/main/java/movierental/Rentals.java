package movierental;

import java.util.LinkedList;
import java.util.List;

public class Rentals {

    private List<Rental> rentals = new LinkedList<>();

    public double getAmounts() {
        return rentals.stream()
                .mapToDouble(Rental::getAmounts)
                .sum();
    }

    public int getFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::getFrequentRenterPoints)
                .sum();
    }

    public String getFiguresForRental() {
        return rentals.stream()
                .map(Rental::getFiguresForRental)
                .reduce("", (figuresA, figuresB) -> figuresA + figuresB);
    }

    public void add(Rental rental) {
        if(rental == null) {
            throw new IllegalArgumentException();
        }
        rentals.add(rental);
    }
}


