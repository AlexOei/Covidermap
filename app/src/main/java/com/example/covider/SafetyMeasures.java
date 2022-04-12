package com.example.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class SafetyMeasures extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safety_measures);
    }

    public void safetyHandler(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.Excellent:
                if (checked)

                    break;
            case R.id.Average:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.Poor:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void submitButtonHandler(View view) {
        // Is the button now checked?
        startActivity(new Intent(SafetyMeasures.this,MapsActivity.class));
    }
}