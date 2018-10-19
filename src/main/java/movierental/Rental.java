package movierental;

/**
 * The rental class represents a customer renting a movie.
 */
class Rental {

    private Movie _movie;
    private int _daysRented;

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public PriceCode getPriceCode() {
        return _movie.getPriceCode();
    }

    public String getTitle() {
        return _movie.getTitle();
    }

    public Movie getMovie() {
        return _movie;
    }
}
