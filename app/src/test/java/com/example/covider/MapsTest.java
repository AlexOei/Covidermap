package com.example.covider;

import static org.junit.Assert.assertEquals;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;

import org.junit.Test;
import org.mockito.Mockito;

public class MapsTest {

    @Test
    public void testGetUserReference() {
        MapsLogic maps = Mockito.mock(MapsLogic.class);
        Button button = Mockito.mock(Button.class);
        Class clas = Mockito.mock(Class.class);
        Intent i = Mockito.mock(Intent.class);
        View view = Mockito.mock(View.class);
        Mockito.doNothing().when(view).getContext().startActivity(i);
        Mockito.verify(maps, Mockito.times(1)).setButton(button, clas);

    }



}
