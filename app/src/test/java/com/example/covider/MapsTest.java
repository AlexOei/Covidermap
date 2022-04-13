package com.example.covider;

import static org.junit.Assert.assertEquals;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Before;
import org.junit.Test;

public class MapsTest {


    @Test
    public void testGetUserReference() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.useEmulator("localhost", 9000);
        Firebase firebase = new Firebase(database);
        assertEquals(firebase.getUserReference().getClass(), DatabaseReference.class);

    }



}
