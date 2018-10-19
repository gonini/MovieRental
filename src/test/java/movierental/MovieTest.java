package movierental;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private final static String MOVIE_NAME = "곡성";

    @Test
    public void getPriceCode() {
        assertEquals(new Movie(MOVIE_NAME, Movie.NEW_RELEASE).getPriceCode(), Movie.NEW_RELEASE);
    }

    @Test
    public void setPriceCode() {
        Movie movie = new Movie(MOVIE_NAME, Movie.NEW_RELEASE);
        movie.setPriceCode(Movie.CHILDRENS);
        assertEquals(movie.getPriceCode(), Movie.CHILDRENS);
    }

    @Test
    public void getTitle() {
        assertEquals(new Movie(MOVIE_NAME, Movie.NEW_RELEASE).getTitle(), MOVIE_NAME);
    }
}