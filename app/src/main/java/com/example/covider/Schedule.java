package com.example.covider;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Schedule {

    private DatabaseReference databaseReference;
    public Schedule(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference();
    }

    public Task<Void> add(Building build){
        return databaseReference.push().setValue(build);
    }
}
