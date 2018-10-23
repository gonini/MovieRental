package movierental;

class Customer {
    private String _name;
    private Rentals rentals = new Rentals();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        return getHeader() +
                getText() +
                getFooter();
    }

    private String getHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    private String getText() {
        return rentals.getFiguresForRental();
    }

    private String getFooter() {
        return "Amount owed is " + String.valueOf(rentals.getAmounts()) + "\n" +
                "You earned " + String.valueOf(rentals.getFrequentRenterPoints()) +
                " frequent renter points";
    }
}
