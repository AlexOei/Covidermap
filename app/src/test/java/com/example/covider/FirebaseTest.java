package com.example.covider;

import static org.junit.Assert.assertEquals;

import android.widget.TextView;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


public class FirebaseTest {


    @Test
    public void getUserReferenceTest(){
        Firebase firebase = new Firebase();
        assertEquals(firebase.getUserReferenceTest(), "databaseReference");

    }

    @Test
    public void getLocationsTest(){
        Firebase firebase = new Firebase();
        assertEquals(firebase.getLocationsTest("location"), "location");

    }

    @Test
    public void checkMarker(){
        Firebase firebase = new Firebase();
        LatLng ltln = new LatLng(34.028, -118.2806);
        assertEquals(firebase.getMapLocationsTest((float) 12.1234).getPosition(),ltln );
    }






}
