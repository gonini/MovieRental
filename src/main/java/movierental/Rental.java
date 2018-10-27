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

    public double getAmounts() {
        return movie.getPrice(getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    public String getFiguresForRental() {
        return "\t" + getTitle() + "\t" + String.valueOf(getAmounts()) + "\n";
    }
}
