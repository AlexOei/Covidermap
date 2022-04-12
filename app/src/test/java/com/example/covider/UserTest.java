package com.example.covider;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator;

public class UserTest {

    @Test
    public void testUser(){

       Map <String, String> map1 = new HashMap<>();
       map1.put("1", "2");
       Map <String, String> map2 = new HashMap<>();
       map2.put("3", "4");
       ArrayList<String> health = new ArrayList<>();
       health.add("false");
       ArrayList<User> close = new ArrayList<User>();
       close.add(new User());


       User u = new User("alex", "oei", "alexanxo@usc.edu", "111111",
               false, map2, map1, health, close, false );
       User use = new User();


       assertEquals(u.getFirstName(), "alex");
       assertEquals(u.getLastName(), "oei");
       assertEquals(u.getEmail(), "alexanxo@usc.edu");
       assertEquals(u.getPassword(), "111111");
       assertFalse(u.isInstructor());
       assertEquals(u.getFreq_visited(), map2);
       assertEquals(u.getShould_visit(), map1);
       assertEquals(u.getCloseContacts(), close);
       assertFalse(u.isHaveCovid());


    }

}
