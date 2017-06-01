package com.tech.em.refuelingcalculation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tech.em.refuelingcalculation.calculator.RefuelingCalculator;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText leftFuelTankEditText;
    private EditText rightFuelTankEditText;
    private EditText centerFuelTankEditText;
    private EditText totalRefuelingEditText;
    private EditText fuelDencityEditText;
    private EditText fuelAmountInLitersEditText;
    private EditText fuelAmountInKilogramsEditText;
    private Button resultAllBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListenersForView();
    }

    public void initViews(){
        leftFuelTankEditText = (EditText) findViewById(R.id.leftFuelTankEdit);
        rightFuelTankEditText = (EditText) findViewById(R.id.rightFuelTankEdit);
        centerFuelTankEditText = (EditText) findViewById(R.id.ctrFuelTankEdit);
        totalRefuelingEditText = (EditText) findViewById(R.id.totalRefuelingEdit);
        fuelDencityEditText = (EditText) findViewById(R.id.densityEdit);
        fuelAmountInLitersEditText = (EditText) findViewById(R.id.resultLitersEdit);
        fuelAmountInKilogramsEditText = (EditText) findViewById(R.id.resultKilogramsEdit);
        resultAllBtn = (Button) findViewById(R.id.resultAllBtn);
    }

    public void setListenersForView(){
        resultAllBtn.setOnClickListener(this);
    }

    public void setValueInEditText(double value, EditText editText){
        int convertionValueToInt = (int) value;
        String convertionValueToString = Integer.toString(convertionValueToInt);
        editText.setText(convertionValueToString);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == resultAllBtn.getId()) {
            double leftFuelTankRemainder = Double.parseDouble(leftFuelTankEditText.getText().
                                                                                   toString().
                                                                                   replaceAll(" ", ""));
            double rightFuelTankRemainder = Double.parseDouble(rightFuelTankEditText.getText().
                                                                                     toString().
                                                                                     replaceAll(" ", ""));
            double centerFuelTankRemainder = Double.parseDouble(centerFuelTankEditText.getText().
                                                                                       toString().
                                                                                       replaceAll(" ", ""));
            double totalRefueling = Double.parseDouble(totalRefuelingEditText.getText().
                                                                              toString().
                                                                              replaceAll(" ", ""));
            double fuelDencity = Double.parseDouble(fuelDencityEditText.getText().
                                                                        toString().
                                                                        replaceAll(" ", ""));

            RefuelingCalculator refuelingCalculator = new RefuelingCalculator();
            refuelingCalculator.setLeftTankRemainder(leftFuelTankRemainder);
            refuelingCalculator.setRightTankRemainder(rightFuelTankRemainder);
            refuelingCalculator.setCenterTankRemainder(centerFuelTankRemainder);
            refuelingCalculator.setTotalRefueling(totalRefueling);
            refuelingCalculator.setFuelDencity(fuelDencity);

            double fuelAmountInLiters;
            double fuelRemainderInKilograms;
            fuelAmountInLiters = refuelingCalculator.
                                                     calculateRefueldFuelAmountInLiters();
            fuelRemainderInKilograms = refuelingCalculator.
                                                     calculateFuelRemainderInKilograms();

            setValueInEditText(fuelAmountInLiters, fuelAmountInLitersEditText);
            setValueInEditText(fuelRemainderInKilograms, fuelAmountInKilogramsEditText);
        }
    }
}