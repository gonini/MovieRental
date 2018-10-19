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
        customer.addRental(new Rental(new Movie(MOVIE_NAME, Movie.NEW_RELEASE), DAYS_RENTED));
    }

    @Test
    public void getName() {
        Customer customer = new Customer(CUSTOMER_NAME);
        assertEquals(customer.getName(), CUSTOMER_NAME);
    }

    @Test
    public void statement_none_rental() {
        String result = "Rental Record for " + CUSTOMER_NAME + "\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        Customer customer = new Customer(CUSTOMER_NAME);
        assertEquals(customer.statement(), result);
    }

    @Test
    public void statement_regular_rental_less_than_2_days() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(Movie.REGULAR, 1));
        assertEquals(customer.statement(), createResult(1, 2.0));
    }

    @Test
    public void statement_regular_rental_more_than_2_days() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(Movie.REGULAR, 5));
        assertEquals(customer.statement(), createResult(1, 6.5));
    }

    @Test
    public void statement_new_release_rental() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(Movie.NEW_RELEASE, 10));
        assertEquals(customer.statement(), createResult(2, 30.0));
    }

    @Test
    public void statement_childrens_rental_less_than_2_days() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(Movie.CHILDRENS, 1));
        assertEquals(customer.statement(), createResult(1, 1.5));
    }

    @Test
    public void statement_childrens_rental_more_than_2_days() {
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(Movie.CHILDRENS, 5));
        assertEquals(customer.statement(), createResult(1, 4.5));
    }

    @Test
    public void statement_multiple() {
        String result = "Rental Record for 고구미\n" +
                "\t" + MOVIE_NAME + "\t4.5\n" +
                "\t" + MOVIE_NAME + "\t1.5\n" +
                "\t" + MOVIE_NAME + "\t30.0\n" +
                "\t" + MOVIE_NAME + "\t6.5\n" +
                "\t" + MOVIE_NAME + "\t2.0\n" +
                "Amount owed is 44.5\n" +
                "You earned 6 frequent renter points";
        Customer customer = new Customer(CUSTOMER_NAME);
        customer.addRental(createRental(Movie.CHILDRENS, 5));
        customer.addRental(createRental(Movie.CHILDRENS, 1));
        customer.addRental(createRental(Movie.NEW_RELEASE, 10));
        customer.addRental(createRental(Movie.REGULAR, 5));
        customer.addRental(createRental(Movie.REGULAR, 1));
        assertEquals(customer.statement(), result);
    }

    private String createResult(int frequent, double amount) {
        return "Rental Record for " + CUSTOMER_NAME + "\n" +
                "\t" + MOVIE_NAME + "\t" + amount + "\n" +
                "Amount owed is " + amount + "\n" +
                "You earned " + frequent + " frequent renter points";
    }

    private Rental createRental(int movieType, int daysRented) {
        return new Rental(new Movie(MOVIE_NAME, movieType), daysRented);
    }
}