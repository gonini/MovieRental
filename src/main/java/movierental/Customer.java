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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        totalAmount = rentals.getAmounts();
        frequentRenterPoints = rentals.getFrequentRenterPoints();
        result += rentals.getFiguresForRental();

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }
}
