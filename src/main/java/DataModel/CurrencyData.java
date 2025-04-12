package DataModel;

import java.util.Date;

public class CurrencyData {
    private Date date;
    private double currencyValue;


    public CurrencyData(Date date, double currencyValue) {
        this.date = date;
        this.currencyValue = currencyValue;
    }


    public Date getDate() {
        return date;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }


    public void setDate(Date date) {
        this.date = date;
    }

    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }
}

