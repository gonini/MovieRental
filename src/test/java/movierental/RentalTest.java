package movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RentalTest {
    private final static int DAY_RENTED = 10;
    private final static String MOVIE_NAME = "개미";

    @Test
    public void getMovie() {
        Movie movie = new Movie(MOVIE_NAME, new NewReleaseSettlement());
        Rental rental = new Rental(movie, DAY_RENTED);
        assertNotNull(rental.getMovie());
        assertEquals(movie, rental.getMovie());
    }
}
