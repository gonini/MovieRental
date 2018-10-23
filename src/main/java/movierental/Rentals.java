package movierental;

import java.util.LinkedList;
import java.util.List;

public class Rentals implements ProductRental {

    private List<ProductRental> rentals = new LinkedList<>();

    public double getAmounts() {
        return rentals.stream()
                .mapToDouble(ProductRental::getAmounts)
                .sum();
    }

    public int getFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(ProductRental::getFrequentRenterPoints)
                .sum();
    }

    @Override
    public String getFiguresForRental() {
        return rentals.stream()
                .map(ProductRental::getFiguresForRental)
                .reduce("", (figuresA, figuresB) -> figuresA + figuresB);
    }

    public void add(ProductRental rental) {
        if(rental == null) {
            throw new IllegalArgumentException();
        }
        rentals.add(rental);
    }
}


