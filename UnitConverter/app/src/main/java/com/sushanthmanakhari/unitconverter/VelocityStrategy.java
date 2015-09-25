
package com.sushanthmanakhari.unitconverter;

public class VelocityStrategy implements Strategy {
	public double Convert(String from, String to, double input) {
		// TODO Auto-generated method stub
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmilesperh)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitkmph)))){
		//if((from.equals("miles/hr")) && (to.equals("Km/hr"))){
			double ret = input*1.60934;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitkmph)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmilesperh)))){
		//if((from.equals("Km/hr")) && (to.equals("miles/hr"))){
			double ret = input*0.62137;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmilesperh)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmeterpers)))){
		//if((from.equals("miles/hr")) && (to.equals("m/s"))){
			double ret = input*1609.34/3600;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmeterpers)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmilesperh)))){
		//if((from.equals("m/s")) && (to.equals("miles/hr"))){
			double ret = input*3600/1609.34;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmilesperh)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitfeetpers)))){
		//if((from.equals("miles/hr")) && (to.equals("feet/s"))){
			double ret = input*5280/3600;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitfeetpers)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmilesperh)))){
		//if((from.equals("feet/s")) && (to.equals("miles/hr"))){
			double ret = input*3600/5280;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitkmph)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmeterpers)))){
		//if((from.equals("Km/hr")) && (to.equals("m/s"))){
			double ret = input*1000/3600;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmeterpers)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitkmph)))){
		//if((from.equals("m/s")) && (to.equals("Km/hr"))){
			double ret = input*3600/1000;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitkmph)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitfeetpers)))){
		//if((from.equals("Km/hr")) && (to.equals("feet/s"))){
			double ret = input*3280.84/3600;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitfeetpers)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitkmph)))){
		//if((from.equals("feet/s")) && (to.equals("Km/hr"))){
			double ret = input*3600/3280.84;
			return ret;
		}
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmeterpers)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitfeetpers)))){
		//if((from.equals("m/s")) && (to.equals("feet/s"))){
			double ret = input*3.28084;
			return ret;
		}
		
		
		if((from.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitfeetpers)) && to.equals(UnitConverter.getInstance().getApplicationContext().getResources().getString(R.string.velocityunitmeterpers)))){
		//if((from.equals("feet/s")) && (to.equals("m/s"))){
			double ret = input/3.28084;
			return ret;
		}
		
		if(from.equals(to)){
			return input;	
		}
		return 0;
	}


}
