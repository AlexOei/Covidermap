package com.example.covider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClassSectionActivity extends AppCompatActivity {
    Button submitClasses, switchViews;
    EditText firstSection, firstCode, secondSection, secondCode;
    EditText thirdCode, thirdSection, fourthCode, fourthSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_section);


        submitClasses = findViewById(R.id.submitClasses);
        firstCode = findViewById(R.id.code1);
        firstSection = findViewById(R.id.firstSection);
        secondCode = findViewById(R.id.code2);
        secondSection = findViewById(R.id.section2);
        thirdCode = findViewById(R.id.code3);
        thirdSection = findViewById(R.id.section3);
        fourthCode = findViewById(R.id.code4);
        fourthSection = findViewById(R.id.section4);
        switchViews = findViewById(R.id.frequently);

        switchViews.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent i = new Intent(view.getContext(), FrequentlyVisited.class);
                startActivity(i);
            }
        });


        submitClasses.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                String sectionOne = firstSection.getText().toString().trim();
                String codeOne = firstCode.getText().toString().trim();
                String sectionTwo = secondSection.getText().toString().trim();
                String codeTwo = secondCode.getText().toString().trim();
                String sectionThree = thirdSection.getText().toString().trim();
                String codeThree = thirdCode.getText().toString().trim();
                String sectionFour = fourthSection.getText().toString().trim();
                String codeFour = fourthCode.getText().toString().trim();



                Map<String, String> Codes = new HashMap<>();
                Codes.put(sectionOne, codeOne);
                if (sectionOne.isEmpty()) {
                    firstSection.setError("Please Enter at least one class");
                    return;
                }

                if (codeOne.isEmpty()) {
                    firstCode.setError("Please Enter at least one class");
                    return;
                }
                if (!codeTwo.isEmpty()){
                    Codes.put(sectionTwo, codeTwo);
                }

                if (!codeThree.isEmpty()){
                    Codes.put(sectionThree, codeThree);
                }

                if (!codeFour.isEmpty()){
                    Codes.put(sectionFour, codeFour);
                }
                Intent i = new Intent(view.getContext(), MapsActivity.class);
                startActivity(i);
            }




            /*FirebaseDatabase.getInstance().getReference("Users")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .child("should_visit").setValue(Codes)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ClassSectionActivity.this, "Code has been registered successfully!", Toast.LENGTH_LONG ).show();
                            }else{
                                Toast.makeText(ClassSectionActivity.this, "Failed to register!", Toast.LENGTH_LONG ).show();
                            }
                        }
                    });*/

        });
    }



}