package com.example.covider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class FirebaseTest {


    @Test
    public void testGetUserReference() {
        Firebase firebase = Mockito.mock(Firebase.class);
        DatabaseReference ref = Mockito.mock(DatabaseReference.class);
        Mockito.when(firebase.getUserReference()).thenReturn(ref);
        assertEquals(ref, firebase.getUserReference());

    }

    @Test
    public void testGetUser(){
        Firebase firebase = Mockito.mock(Firebase.class);
        TextView text = Mockito.mock(TextView.class);
        TextView text1 = Mockito.mock(TextView.class);
        TextView text2 = Mockito.mock(TextView.class);
        TextView text3 = Mockito.mock(TextView.class);
        TextView text4 = Mockito.mock(TextView.class);
        Mockito.doNothing().when(firebase).getUser(text, text1, text2, text3, text4);
        firebase.getUser(text, text1, text2, text3, text4);
        Mockito.verify(firebase, Mockito.times(1)).getUser(text, text1, text2, text3, text4);
    }

}
