

package com.sushanthmanakhari.unitconverter;

public class PowerStrategy implements Strategy {

	public double Convert(String from, String to, double input) {
		// TODO Auto-generated method stub
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunitwatts)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunithorseposer)))){
		//if((from.equals("watts")) && (to.equals("horsepower"))){
			double ret = 0.00134*input;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunithorseposer)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunitwatts)))){
		//if((from.equals("horsepower")) && (to.equals("watts"))){
			double ret = 745.7*input;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunitwatts)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunitkilowatts)))){
		//if((from.equals("watts")) && (to.equals("kilowatts"))){
			double ret = input/1000;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunitkilowatts)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunitwatts)))){
		//if((from.equals("kilowatts")) &&(to.equals("watts"))){
			double ret = input*1000;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunitkilowatts)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunithorseposer)))){
		//if((from.equals("kilowatts")) && (to.equals("horsepower"))){
			double ret = input*1.34102;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunithorseposer)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.powerunitkilowatts)))){
		//if((from.equals("horsepower")) &&(to.equals("kilowatts"))){
			double ret = input*0.7457;
			return ret;
		}
		if(from.equals(to)){
			return input;	
		}
		return 0.0;
	}

}
