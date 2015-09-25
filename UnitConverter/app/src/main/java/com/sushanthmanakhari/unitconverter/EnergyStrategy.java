
package com.sushanthmanakhari.unitconverter;


public class EnergyStrategy implements Strategy {

	public double Convert(String from, String to, double input) {
		// TODO Auto-generated method stub
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitcalories)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitkilocalories)))){
		//if((from.equals("calories")) &&(to.equals("kilocalories"))){
			double ret = input/1000;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitkilocalories)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitcalories)))){
		//if((from.equals("kilocalories")) && (to.equals("calories"))){
			double ret = input*1000;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitcalories)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitjoules)))){
		//if((from.equals("calories")) && (to.equals("joules"))){
			double ret = input*4.1868;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitjoules)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitcalories)))){
		//if((from.equals("joules")) && (to.equals("calories"))){
			double ret = input*0.23885;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitkilocalories)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitjoules)))){
		//if((from.equals("kilocalories")) && (to.equals("joules"))){
			double ret = input*4186.8;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitjoules)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.energyunitkilocalories)))){
		//if((from.equals("joules")) && (to.equals("kilocalories"))){
			double ret = input/4186.8;
			return ret;
		}
		if(from.equals(to)){
			return input;	
		}
		return 0.0;
	}


}
