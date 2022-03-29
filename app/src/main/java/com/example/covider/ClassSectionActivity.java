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
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ClassSectionActivity extends AppCompatActivity {
    Button submitClasses;
    EditText firstSection, firstCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_section);


        submitClasses = findViewById(R.id.submitClasses);
        firstCode = findViewById(R.id.firstCode);
        firstSection = findViewById(R.id.firstSection);



        submitClasses.setOnClickListener(view -> {
            String sectionOne = firstSection.getText().toString().trim();
            String codeOne = firstCode.getText().toString().trim();
            ArrayList<String> Sections = new ArrayList<String>();
            ArrayList<String> Codes = new ArrayList<String>();
            Sections.add(sectionOne);
            Codes.add(codeOne);
            if (sectionOne.isEmpty()) {
                firstSection.setError("Please Enter at least one class");
                return;
            }

            if (codeOne.isEmpty()) {
                firstCode.setError("Please Enter at least one class");
                return;
            }

            FirebaseDatabase.getInstance().getReference("Users")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .child("Schedule").child("Codes").setValue(Codes)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(ClassSectionActivity.this, "Code has been registered successfully!", Toast.LENGTH_LONG ).show();
                            }else{
                                Toast.makeText(ClassSectionActivity.this, "Failed to register!", Toast.LENGTH_LONG ).show();
                            }
                        }
                    });

        });
    }



}