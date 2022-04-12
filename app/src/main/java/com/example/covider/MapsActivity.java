package com.example.covider;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.covider.databinding.ActivityMapsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapsLogic maps = new MapsLogic();
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Button locations, profile, healthCheck, checkIn, logOut, sections;
        locations = findViewById(R.id.locations);
        profile = findViewById(R.id.profile);
        healthCheck = findViewById(R.id.healthCheck);
        checkIn = findViewById(R.id.checkIn);
        logOut = findViewById(R.id.logOut);
        sections = findViewById(R.id.section);

        maps.setButton(locations, ListActivity.class);
        maps.setButton(profile, Profile.class);
        maps.setButton(sections, ClassSectionActivity.class);
        maps.setButton(checkIn, SafetyMeasures.class);
        maps.setButton(healthCheck, CovidSymptoms.class);
        maps.setButton(logOut, Login.class);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Firebase firebase = new Firebase();

        firebase.getMapLocations(mMap, BitmapDescriptorFactory.HUE_BLUE, "freq_visited");
        firebase.getMapLocations(mMap, BitmapDescriptorFactory.HUE_RED, "should_visit");


        LatLng start =new LatLng (34.0216751099, -118.2854461670);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start, 15));



    }




}