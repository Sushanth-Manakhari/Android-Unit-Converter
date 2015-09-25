package com.sushanthmanakhari.unitconverter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//this is for git testing

public class UnitConverter extends Activity implements OnClickListener, AdapterView.OnItemSelectedListener{
    /** Called when the activity is first created. */

    private Spinner SpinnerUnit;
    private EditText inputValue;
    private Spinner SpinnerFrom;
    private Spinner SpinnerTo;
    private Button ButtonConvert;
    private EditText ResultView;
    ArrayAdapter<String> unitarray;
    ArrayAdapter<String> unitarrayadapter;
    private Strategy currentStrategy;
    private Strategy lastStrategy;
    private String unitfrom;
    private String unitto;
    private static UnitConverter instance;

    //this is to test the Git repository
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //Som++
        //to get the parameter passed from the URI that has launched this app
        final Intent intent = getIntent();
        String scheme = intent.getScheme();
        if(scheme != null){
            final Uri myURI=intent.getData();
            String queryString = new String();

            if(myURI!=null)
            {
                queryString = myURI.getQuery();
            }
            String split1 = "&";
            String split2 = "=";

            if (queryString != null)
            {
                final String[] arrParameters = queryString.split("&");
                for (final String tempParameterString : arrParameters)
                {
                    final String[] arrTempParameter = tempParameterString.split("=");
                    if (arrTempParameter.length >= 2)
                    {
                        final String parameterKey = arrTempParameter[0];
                        final String parameterValue = arrTempParameter[1];
                        //do something with the parameters
                        Toast.makeText(this, parameterValue, 500).show();
                    }
                }
            }

        }
        //++Som


        setContentView(R.layout.main);


        SpinnerUnit = (Spinner)findViewById(R.id.SpinnerUnit);
        SpinnerUnit.setOnItemSelectedListener(this);

        unitarray=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        unitarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerUnit.setAdapter(unitarray);
        unitarray.add(getResources().getString(R.string.unit1));
        unitarray.add(getResources().getString(R.string.unit2));
        unitarray.add(getResources().getString(R.string.unit3));
        unitarray.add(getResources().getString(R.string.unit4));
        unitarray.add(getResources().getString(R.string.unit5));
        unitarray.add(getResources().getString(R.string.unit6));
        unitarray.add(getResources().getString(R.string.unit7));
        unitarray.add(getResources().getString(R.string.unit8));
        unitarray.add(getResources().getString(R.string.unit9));
        unitarray.setNotifyOnChange(true);

        SpinnerFrom = (Spinner)findViewById(R.id.SpinnerFrom);
        SpinnerFrom.setOnItemSelectedListener(this);
        SpinnerTo = (Spinner)findViewById(R.id.SpinnerTo);
        SpinnerTo.setOnItemSelectedListener(this);

        unitarrayadapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        unitarrayadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerFrom.setAdapter(unitarrayadapter);
        SpinnerTo.setAdapter(unitarrayadapter);

        unitarrayadapter.setNotifyOnChange(true);

        ResultView = (EditText)findViewById(R.id.TextViewResult);
        ResultView.setClickable(false);

        ButtonConvert = (Button)findViewById(R.id.Button01);

        ButtonConvert.setOnClickListener(this);

        inputValue = (EditText)findViewById(R.id.EditTextValue);

        //initialization
        currentStrategy = new TemperatureStrategy();

        lastStrategy = currentStrategy;

        instance = this;



    }

    public static UnitConverter getInstance(){
        return instance;
    }

    public void onItemSelected(AdapterView<?> parent){
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

    public void onItemSelected(AdapterView<?> parent, View v,
                               int position, long id){

        if(v.getParent() == SpinnerUnit){

            switch(position){
                case 0:
                    setStrategy(new TemperatureStrategy());
                    break;

                case 1:
                    setStrategy( new WeightStrategy());
                    break;

                case 2:
                    setStrategy(new LengthStrategy());
                    break;

                case 3:
                    setStrategy(new PowerStrategy());
                    break;

                case 4:
                    setStrategy(new EnergyStrategy());
                    break;

                case 5:
                    setStrategy(new VelocityStrategy());
                    break;

                case 6:
                    setStrategy(new AreaStrategy());
                    break;

                case 7:
                    setStrategy(new VolumeStrategy());
                    break;

                case 8:
                    setStrategy(new CurrencyStrategy());
                    break;
            }


            fillFromToSpinner(position);

            SpinnerFrom.setSelection(0);
            SpinnerTo.setSelection(0);

            //If only first spinner is selected and
            //the from and to spinners are not clicked at all
            unitfrom = (String)(SpinnerFrom.getItemAtPosition(0).toString());
            unitto = (String)(SpinnerTo.getItemAtPosition(0).toString());

            //reset the result
            ResultView.setText("");


        }
        else if(v.getParent() == SpinnerFrom){
            unitfrom = (String)(SpinnerFrom.getSelectedItem().toString());
        }

        else if(v.getParent() == SpinnerTo){
            unitto = (String)(SpinnerTo.getSelectedItem().toString());
        }
    }


    private void fillFromToSpinner(int position){

        switch(position)
        {
            case 0:
                fillSpinnerWithTempUnit();
                break;

            case 1:
                fillSpinnerWithWeightUnit();
                break;

            case 2:
                fillSpinnerWithLengthUnit();
                break;

            case 3:
                fillSpinnerWithPowerUnit();
                break;

            case 4:
                fillSpinnerWithenErgyUnit();
                break;

            case 5:
                fillSpinnerWithVelocityUnit();
                break;

            case 6:
                fillSpinnerWithAreaUnit();
                break;

            case 7:
                fillSpinnerWithVolumeUnit();
                break;

            case 8:
                fillSpinnerWithCurrencyUnit();
        }

    }

    private void fillSpinnerWithTempUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.temperatureunitc));
        unitarrayadapter.add(getResources().getString(R.string.temperatureunitf));
        unitarrayadapter.notifyDataSetChanged();
    }

    private void fillSpinnerWithWeightUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.weightunitkg));
        unitarrayadapter.add(getResources().getString(R.string.weightunitgm));
        unitarrayadapter.add(getResources().getString(R.string.weightunitlb));
        unitarrayadapter.add(getResources().getString(R.string.weightunitounce));
        unitarrayadapter.add(getResources().getString(R.string.weightunitmg));
        unitarrayadapter.notifyDataSetChanged();
    }

    private void fillSpinnerWithLengthUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.lengthunitmile));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitkm));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitm));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitcm));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitmm));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitinch));
        unitarrayadapter.add(getResources().getString(R.string.lengthunitfeet));
    }

    private void fillSpinnerWithPowerUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.powerunitwatts));
        unitarrayadapter.add(getResources().getString(R.string.powerunithorseposer));
        unitarrayadapter.add(getResources().getString(R.string.powerunitkilowatts));
    }

    private void fillSpinnerWithenErgyUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.energyunitcalories));
        unitarrayadapter.add(getResources().getString(R.string.energyunitjoules));
        unitarrayadapter.add(getResources().getString(R.string.energyunitkilocalories));

    }

    private void fillSpinnerWithVelocityUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.velocityunitkmph));
        unitarrayadapter.add(getResources().getString(R.string.velocityunitmilesperh));
        unitarrayadapter.add(getResources().getString(R.string.velocityunitmeterpers));
        unitarrayadapter.add(getResources().getString(R.string.velocityunitfeetpers));
    }

    private void fillSpinnerWithAreaUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.areaunitsqkm));
        unitarrayadapter.add(getResources().getString(R.string.areaunitsqmiles));
        unitarrayadapter.add(getResources().getString(R.string.areaunitsqm));
        unitarrayadapter.add(getResources().getString(R.string.areaunitsqcm));
        unitarrayadapter.add(getResources().getString(R.string.areaunitsqmm));
        unitarrayadapter.add(getResources().getString(R.string.areaunitsqyard));
    }

    private void fillSpinnerWithVolumeUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.volumeunitlitres));
        unitarrayadapter.add(getResources().getString(R.string.volumeunitmillilitres));
        unitarrayadapter.add(getResources().getString(R.string.volumeunitcubicm));
        unitarrayadapter.add(getResources().getString(R.string.volumeunitcubiccm));
        unitarrayadapter.add(getResources().getString(R.string.volumeunitcubicmm));
        unitarrayadapter.add(getResources().getString(R.string.volumeunitcubicfeet));
    }

    private void fillSpinnerWithCurrencyUnit(){
        unitarrayadapter.clear();
        unitarrayadapter.add(getResources().getString(R.string.currencyunitusd));
        unitarrayadapter.add(getResources().getString(R.string.currencyunitinr));
    }

    public void onClick(View v){
        if(v == ButtonConvert){
            if(!inputValue.getText().toString().equals("")){
                double in = Double.parseDouble(inputValue.getText().toString());
                double result = currentStrategy.Convert(unitfrom, unitto, in);
                ResultView.setText(Double.toString(result));
            }
            else {
                ResultView.setText("");
            }
        }
    }

    private void setStrategy(Strategy s){

        lastStrategy = currentStrategy;
        currentStrategy = s;
        //make the last strategy eligible for garbage collection
        lastStrategy = null;
    }
}