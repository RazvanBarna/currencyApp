package DataModel;

public class Country {
    private String countryName;
    private String countryIso3;
    private String countryIsoNumeric;
    private String currencyName;
    private String currencyCode;
    private String currencyNumber;

    public Country(String countryName, String countryIso3, String countryIsoNumeric, String currencyName, String currencyCode, String currencyNumber) {
        this.countryName = countryName;
        this.countryIso3 = countryIso3;
        this.countryIsoNumeric = countryIsoNumeric;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
        this.currencyNumber = currencyNumber;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryIso3='" + countryIso3 + '\'' +
                ", countryIsoNumeric=" + countryIsoNumeric +
                ", currencyName='" + currencyName + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", currencyNumber=" + currencyNumber +
                '}';
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryIso3() {
        return countryIso3;
    }

    public void setCountryIso3(String countryIso3) {
        this.countryIso3 = countryIso3;
    }

    public String getCountryIsoNumeric() {
        return countryIsoNumeric;
    }

    public void setCountryIsoNumeric(String countryIsoNumeric) {
        this.countryIsoNumeric = countryIsoNumeric;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyNumber() {
        return currencyNumber;
    }

    public void setCurrencyNumber(String currencyNumber) {
        this.currencyNumber = currencyNumber;
    }
}
