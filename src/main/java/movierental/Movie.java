package movierental;

class Movie {
    private String _title;
    private PriceCode _priceCode;

    public Movie(String title, PriceCode priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        _priceCode = priceCode;
    }
    public String getTitle() {
        return _title;
    }
}