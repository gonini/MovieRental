package movierental;

abstract class Settlement {

    abstract double getPrice(int daysRented);

    double getLongTermRentalCosts(int daysRented,
                                  int longTermLoanStnd,
                                  double termRentalAmtDay) {
        double ret = 0;
        if (daysRented > longTermLoanStnd)
            ret = (daysRented - longTermLoanStnd) * termRentalAmtDay;
        return ret;
    }

    int getFrequentPoints(int daysRented)
    {
        return  1;
    }
}
