package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
class Rental implements ProductRental {

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

    @Override
    public double getAmounts() {
        return movie.getPrice(getDaysRented());
    }

    @Override
    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    @Override
    public String getFiguresForRental() {
        return "\t" + getTitle() + "\t" + String.valueOf(getAmounts()) + "\n";
    }
}
