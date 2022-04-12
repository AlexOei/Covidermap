package com.example.covider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        TextView first = findViewById(R.id.name_first);
        TextView last = findViewById(R.id.name_last);
        TextView email = findViewById(R.id.email_profile);
        TextView haveCovid = findViewById(R.id.covid_profile);
        TextView instructor = findViewById(R.id.isInstructor);
        Firebase firebase = new Firebase();

        //DatabaseReference ref = firebase.getUserReference();

        firebase.getUser(first, last, email, haveCovid, instructor);

        /*ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);

                first.setText(user.getFirstName());
                last.setText(user.getLastName());
                email.setText(user.getEmail());
                String covid = new Boolean(user.getHaveCovid()).toString();
                String instruct = new Boolean (user.getIsInstructor()).toString();
                haveCovid.setText(covid);
                instructor.setText(instruct);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/



    }
}