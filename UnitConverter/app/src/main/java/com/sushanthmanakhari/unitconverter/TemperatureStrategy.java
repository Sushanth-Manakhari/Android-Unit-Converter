
package com.sushanthmanakhari.unitconverter;

public class TemperatureStrategy implements Strategy {

	public double Convert(String from, String to, double input) {
		// TODO Auto-generated method stub
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.temperatureunitc)) && to.equals((UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.temperatureunitf))))){
			double ret = (double)((input*9/5)+32);
			return ret;
		}
	
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.temperatureunitf)) && to.equals((UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.temperatureunitc))))){
			double ret = (double)((input-32)*5/9);
			return ret;
		}

	if(from.equals(to)){
		return input;	
	}
	return 0.0;
	}

}
