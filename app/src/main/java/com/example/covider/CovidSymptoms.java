package com.example.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class CovidSymptoms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_symptoms);
    }

    boolean symptoms = false;
    boolean covid = false;

    public void covidHandler(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yesForCovidPositive:
                if (checked)
                    covid = true;

                break;
            case R.id.noForCovidPositive:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void otherSymptomsHandler(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yesForOtherSymptoms:
                if (checked)
                    symptoms = true;
                break;
            case R.id.noForOtherSymptoms:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void feverHandler(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yesForFever:
                if (checked)
                    symptoms = true;
                break;
            case R.id.noForFever:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void soreThroatHandler(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.yesForSoreThroat:
                if (checked)
                    symptoms = true;
                break;
            case R.id.noForSoreThroat:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void submitButtonHandler(View view) {
        // Is the button now checked?
        startActivity(new Intent(view.getContext(),MapsActivity.class));

    }

}