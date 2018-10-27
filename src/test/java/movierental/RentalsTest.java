package movierental;

import org.junit.Test;

import static org.junit.Assert.*;

public class RentalsTest {

    @Test(expected=IllegalArgumentException.class)
    public void add() {
        Rentals rentals = new Rentals();
        rentals.add(null);
    }
}