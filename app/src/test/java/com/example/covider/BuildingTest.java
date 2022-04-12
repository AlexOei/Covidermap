package com.example.covider;


import static org.junit.Assert.*;

import org.junit.Test;

public class BuildingTest {

    @Test
    public void testBuilding() {

        //test full constructor
        Building b = new Building("34", "-118", "ZHS", "Zumberge", 0);

        //test empty constructor
        Building c = new Building();

        //test setters
        c.setLatitude("34");
        c.setLongitude("-118");
        c.setCode("ZHS");
        c.setName("Zumberge");
        c.setRisk(0);

        //test full constructor has correct values
        assertEquals(b.getLatitude(), "34");
        assertEquals(b.getLongitude(), "-118");
        assertEquals(b.getCode(), "ZHS");
        assertEquals(b.getName(), "Zumberge");
        assertEquals(b.getRisk().intValue(), 0);

        //test empty constructor against correct full constructor
        assertEquals(b.getLatitude(), c.getLatitude());
        assertEquals(b.getLongitude(), c.getLongitude());
        assertEquals(b.getCode(), c.getCode());
        assertEquals(b.getName(), c.getName());
        assertEquals(b.getRisk().intValue(), c.getRisk().intValue());



    }
}
