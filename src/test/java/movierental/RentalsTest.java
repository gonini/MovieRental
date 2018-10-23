package movierental;

import org.junit.Test;

import static org.junit.Assert.*;

public class RentalsTest {

    private static final String GONI_TITLE = "고니";
    private static final String CAT_TITLE = "고양이";
    private static int DAYS_RENTED = 4;
    private static int NEW_RELEASE_FACTOR = 3;
    private static double GONI_TITLE_AMOUNTS = DAYS_RENTED * NEW_RELEASE_FACTOR;
    private static double CAT_TITLE_AMOUNTS = DAYS_RENTED * NEW_RELEASE_FACTOR + 3;

    @Test
    public void getAmounts() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie(GONI_TITLE, PriceCode.newRelease), DAYS_RENTED));
        assertEquals(GONI_TITLE_AMOUNTS, rentals.getAmounts(), 0.0);

        rentals.add(new Rental(new Movie(CAT_TITLE, PriceCode.childrens), DAYS_RENTED));
        assertEquals(CAT_TITLE_AMOUNTS, rentals.getAmounts(), 0.0);
    }

    @Test
    public void getFrequentPoints() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie(GONI_TITLE, PriceCode.newRelease), DAYS_RENTED));
        assertEquals(2, rentals.getFrequentRenterPoints());
        rentals.add(new Rental(new Movie(CAT_TITLE, PriceCode.childrens), DAYS_RENTED));
        assertEquals(3, rentals.getFrequentRenterPoints());
    }

    @Test
    public void getFiguresForRental() {
        Rentals rentals = new Rentals();
        rentals.add(new Rental(new Movie(GONI_TITLE, PriceCode.newRelease), DAYS_RENTED));
        rentals.add(new Rental(new Movie(CAT_TITLE, PriceCode.childrens), DAYS_RENTED));

        String expected =
                "\t" + GONI_TITLE + "\t" + String.valueOf(GONI_TITLE_AMOUNTS) + "\n" +
                "\t" + CAT_TITLE + "\t" + String.valueOf(3.0) + "\n";
        assertEquals(expected, rentals.getFiguresForRental());
    }

    @Test(expected=IllegalArgumentException.class)
    public void add() {
        Rentals rentals = new Rentals();
        rentals.add(null);
    }
}