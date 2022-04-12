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
    private ArrayList<Building> buildings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapsLogic maps = new MapsLogic();
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();

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

        /*locations.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(view.getContext(), ListActivity.class);
                startActivity(i);
            }
        });

        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(view.getContext(), Profile.class);
                startActivity(i);
            }
        });

        sections.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent i = new Intent(view.getContext(), ClassSectionActivity.class);
                startActivity(i);
            }

        });

        checkIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent i = new Intent(view.getContext(), SafetyMeasures.class);
                startActivity(i);
            }
        });

        healthCheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent i = new Intent(view.getContext(), CovidSymptoms.class);
                startActivity(i);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(view.getContext(), Login.class);
                startActivity(i);
            }
        });


        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListActivity.class);
                startActivity(i);
            }
        });*/
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        /*String test = "79.4";
        String lol = String.format("A string %s", test);
        LatLng tommy = new LatLng(34.0203590393, -118.2853240967);
        mMap.addMarker(new MarkerOptions().position(tommy).title("tommy trojan").snippet(lol).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));*/

        /*try {
            this.buildings = readJsonStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("freq_visited");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dSnap: snapshot.getChildren()){
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Buildings").child(dSnap.getValue().toString());
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Building build = snapshot.getValue(Building.class);
                            LatLng ltln = new LatLng(Double.parseDouble(build.getLatitude()), Double.parseDouble(build.getLongitude()));
                            mMap.addMarker(new MarkerOptions().position(ltln).title(build.getName()).snippet("Covid Risk: " + build.getRisk().toString()+ " Entry Reqs: See List View ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("should_visit");

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dSnap: snapshot.getChildren()){
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Buildings").child(dSnap.getValue().toString());
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Building build = snapshot.getValue(Building.class);
                            LatLng ltln = new LatLng(Double.parseDouble(build.getLatitude()), Double.parseDouble(build.getLongitude()));
                            mMap.addMarker(new MarkerOptions().position(ltln).title(build.getName()).snippet("Covid Risk: " + build.getRisk().toString()+ " Entry Reqs: See List View ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        /*DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Buildings").child("ABA");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    Building build = snapshot.getValue(Building.class);
                    LatLng ltln = new LatLng(Double.parseDouble(build.getLatitude()), Double.parseDouble(build.getLongitude()));
                    mMap.addMarker(new MarkerOptions().position(ltln).title(build.getName()).snippet(build.getCode()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/
        /*for (int i = 0; i < 1/*this.buildings.size(); i++ ){
            Building test = this.buildings.get(i);
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Buildings");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        Building build = snapshot.getValue(Building.class);
                        LatLng ltln = new LatLng(Double.parseDouble(build.getLatitude()), Double.parseDouble(build.getLongitude()));
                        mMap.addMarker(new MarkerOptions().position(ltln).title(build.getName()).snippet(build.getCode()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            LatLng ltlng = new LatLng(Double.parseDouble(test.getLatitude()), Double.parseDouble(test.getLongitude()));
            mMap.addMarker(new MarkerOptions().position(ltlng).title(test.getName()).snippet(test.getCode()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        }*/


        LatLng start =new LatLng (34.0216751099, -118.2854461670);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start, 15));



    }




}