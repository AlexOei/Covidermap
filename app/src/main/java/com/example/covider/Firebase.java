package com.example.covider;

import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Firebase {

    public DatabaseReference getUserReference(){

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid());

        return ref;

    };

    public void getUser(TextView first, TextView last, TextView email, TextView haveCovid, TextView instructor){

        DatabaseReference ref = getUserReference();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                first.setText(user.getFirstName());
                last.setText(user.getLastName());
                email.setText(user.getEmail());
                String covid = new Boolean(user.isHaveCovid()).toString();
                String instruct = new Boolean (user.isInstructor()).toString();
                haveCovid.setText(covid);
                instructor.setText(instruct);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    };




}
