package com.example.covider;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private ArrayList<Building> buildings;

    InputStream input;
    String file = "tes.json";


    public ArrayList<Building> readJsonStream(InputStream in) throws IOException {
        in = getAssets().open(file);
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }

    public ArrayList<Building> readMessagesArray(JsonReader reader) throws IOException {
        ArrayList<Building> messages = new ArrayList<Building>();

        reader.beginArray();
        while (reader.hasNext()) {
            messages.add(readMessage(reader));
        }
        reader.endArray();
        return messages;
    }

    public Building readMessage(JsonReader reader) throws IOException {
         String latitude = null;
         String longitude = null;
         String title = null;
         String code = null;
         String name = null;


        reader.beginObject();
        while (reader.hasNext()) {
            String building = reader.nextName();
            if (building.equals("latitude")) {
                latitude = reader.nextString();
            } else if (building.equals("longitude")) {
                longitude = reader.nextString();
            } else if (building.equals("title")) {
                title = reader.nextString();
            } else if (building.equals("code")) {
                code = reader.nextString();
            } else if (building.equals("name")){
                name = reader.nextString();
            }  else {
                reader.skipValue();
            }
        }
        reader.endObject();
        Building build = new Building();
        build.setCode(code);
        build.setLatitude(latitude);
        build.setLongitude(longitude);
        build.setTitle(title);
        build.setName(name);
        return build;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListActivity.class);
                startActivity(i);
            }
        });
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

        try {
            this.buildings = readJsonStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < this.buildings.size(); i++ ){
            Building test = this.buildings.get(i);
            LatLng ltlng = new LatLng(Double.parseDouble(test.getLatitude()), Double.parseDouble(test.getLongitude()));
            mMap.addMarker(new MarkerOptions().position(ltlng).title(test.getName()).snippet(test.getCode()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        }
        LatLng start =new LatLng (34.0216751099, -118.2854461670);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(start, 15));



    }




}