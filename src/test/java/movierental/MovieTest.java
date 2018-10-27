package movierental;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private final static String MOVIE_NAME = "곡성";

    @Test
    public void getTitle() {
        assertEquals(MOVIE_NAME, new Movie(MOVIE_NAME, new RegularPrice()).getTitle());
    }
}