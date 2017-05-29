package com.tech.em.refuelingcalculation;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "font/RobotoCondensed-Light.ttf");
        TextView myTextView1 = (TextView) findViewById(R.id.TextView1);
        myTextView1.setTypeface(myTypeface);
    }
}
