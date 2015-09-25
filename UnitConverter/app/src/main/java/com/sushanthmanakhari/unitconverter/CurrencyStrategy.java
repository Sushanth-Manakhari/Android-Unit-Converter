
package com.sushanthmanakhari.unitconverter;

public class CurrencyStrategy implements Strategy {

    public double Convert(String from, String to, double input) {
        // TODO Auto-generated method stub

        if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.currencyunitusd)) && to.equals((UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.currencyunitinr))))){
		    double ret = (double)(input*65);
            return ret;
        }

        if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.currencyunitinr)) && to.equals((UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.currencyunitusd))))){

            double ret = (double)(input*0.01538);
            return ret;
        }

        if(from.equals(to)){
            return input;
        }
        return 0.0;
    }

}