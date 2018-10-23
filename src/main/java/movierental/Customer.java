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
        String result = "Rental Record for " + getName() + "\n";
        result += rentals.getFiguresForRental();
        result += "Amount owed is " + String.valueOf(rentals.getAmounts()) + "\n";
        result += "You earned " + String.valueOf(rentals.getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
}
