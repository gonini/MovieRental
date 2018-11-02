package movierental;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private final static String CUSTOMER_NAME = "고구미";
    private final static String MOVIE_NAME = "공포의 나무";
    private static final int DAYS_RENTED = 30;

    @Test
    public void addRental() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(new Rental(new Movie(MOVIE_NAME, new NewReleaseSettlement()), DAYS_RENTED));
    }

    @Test
    public void getName() {
        Customer customer = new Customer(CUSTOMER_NAME);
        assertEquals(CUSTOMER_NAME, customer.getName());
    }

    @Test
    public void statement_none_rental() {
        String expected = "Rental Record for " + CUSTOMER_NAME + "\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        Customer customer = new Customer(CUSTOMER_NAME);
        assertEquals(expected, customer.statement());
    }

    @Test
    public void statement_regular_rental_less_than_2_days() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(new RegularSettlement(), 1));
        assertEquals(createResult(1, 2.0), customer.statement());
    }

    @Test
    public void statement_regular_rental_more_than_2_days() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(new RegularSettlement(), 5));
        assertEquals(createResult(1, 6.5), customer.statement());
    }

    @Test
    public void statement_new_release_rental() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(new NewReleaseSettlement(), 10));
        assertEquals(createResult(2, 30.0), customer.statement());
    }

    @Test
    public void statement_childrens_rental_less_than_2_days() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(new ChildrenSettlement(), 1));
        assertEquals(createResult(1, 1.5), customer.statement());
    }

    @Test
    public void statement_childrens_rental_more_than_2_days() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(new ChildrenSettlement(), 5));
        assertEquals(createResult(1, 4.5), customer.statement());
    }

    @Test
    public void statement_multiple() {
        String expected = "Rental Record for 고구미\n" +
                "\t" + MOVIE_NAME + "\t4.5\n" +
                "\t" + MOVIE_NAME + "\t1.5\n" +
                "\t" + MOVIE_NAME + "\t30.0\n" +
                "\t" + MOVIE_NAME + "\t6.5\n" +
                "\t" + MOVIE_NAME + "\t2.0\n" +
                "Amount owed is 44.5\n" +
                "You earned 6 frequent renter points";
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(new ChildrenSettlement(), 5));
        customer.addRental(createRental(new ChildrenSettlement(), 1));
        customer.addRental(createRental(new NewReleaseSettlement(), 10));
        customer.addRental(createRental(new RegularSettlement(), 5));
        customer.addRental(createRental(new RegularSettlement(), 1));
        assertEquals(expected, customer.statement());
    }

    private String createResult(int frequent, double amount) {
        return "Rental Record for " + CUSTOMER_NAME + "\n" +
                "\t" + MOVIE_NAME + "\t" + amount + "\n" +
                "Amount owed is " + amount + "\n" +
                "You earned " + frequent + " frequent renter points";
    }

    private Rental createRental(Settlement priceStrategy, int daysRented) {
        return new Rental(new Movie(MOVIE_NAME, priceStrategy), daysRented);
    }
}