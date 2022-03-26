package com.example.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.covider.databinding.ActivityBuildingBinding;

public class BuildingActivity extends AppCompatActivity {
    ActivityBuildingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuildingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null){

            String name = intent.getStringExtra("name");
            String title = intent.getStringExtra("building");
            String code = intent.getStringExtra("code");

            binding.nameProfile.setText(name);
            binding.phoneProfile.setText(title);
            binding.countryProfile.setText(code);


        }

    }


}
