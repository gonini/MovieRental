package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
class Rental  {

    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    private int getDaysRented() {
        return daysRented;
    }

    private String getTitle() {
        return movie.getTitle();
    }

     Movie getMovie() {
        return movie;
    }

    double getAmounts() {
        return movie.getPrice(getDaysRented());
    }

    int getFrequentRenterPoints() {
        return movie.getFrequentPoints(daysRented);
    }

    String getFiguresForRental() {
        return "\t" + getTitle() + "\t" + String.valueOf(getAmounts()) + "\n";
    }
}
