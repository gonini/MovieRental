package movierental;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private final static String MOVIE_NAME = "곡성";

    @Test
    public void getPriceCode() {
        assertEquals(new Movie(MOVIE_NAME, PriceCode.newRelease).getPriceCode(), PriceCode.newRelease);
    }

    @Test
    public void setPriceCode() {
        Movie movie = new Movie(MOVIE_NAME, PriceCode.newRelease);
        movie.setPriceCode(PriceCode.childrens);
        assertEquals(PriceCode.childrens, movie.getPriceCode());
    }

    @Test
    public void getTitle() {
        assertEquals(MOVIE_NAME, new Movie(MOVIE_NAME, PriceCode.newRelease).getTitle());
    }
}