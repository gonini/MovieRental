package movierental;

public interface SettlementStrategy {
    double getPrice(int daysRented);
    int getFrequentPoints(int daysRented);
}
