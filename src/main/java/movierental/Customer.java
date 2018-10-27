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
        return rentals.getRentalInfo(_name);
    }
}
