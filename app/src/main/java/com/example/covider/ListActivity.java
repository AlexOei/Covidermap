package com.example.covider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.sql.Array;
import java.util.ArrayList;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.covider.databinding.ActivityListBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListActivity extends AppCompatActivity {
    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Building> buildingArrayList = new ArrayList();
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MapsActivity.class);
                startActivity(i);
            }
        });




            final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .child("freq_visited");

            final DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference("Users")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .child("should_visit");



            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    for (DataSnapshot dSnap: snapshot.getChildren()){
                        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Buildings").child(dSnap.getValue().toString());

                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Building build = snapshot.getValue(Building.class);
                                buildingArrayList.add(build);
                                ListAdapter listAdapter = new ListAdapter(ListActivity.this, buildingArrayList);
                                binding.listview.setAdapter(listAdapter);
                                binding.listview.setClickable(true);
                                binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                        Intent i = new Intent(ListActivity.this,BuildingActivity.class);
                                        i.putExtra("name", buildingArrayList.get(position).getName());
                                        i.putExtra("risk", buildingArrayList.get(position).getRisk().toString());
                                        i.putExtra("code", buildingArrayList.get(position).getCode());
                                        startActivity(i);

                                    }
                                });
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dSnap: snapshot.getChildren()){
                    final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Buildings").child(dSnap.getValue().toString());

                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Building build = snapshot.getValue(Building.class);
                            buildingArrayList.add(build);
                            ListAdapter listAdapter = new ListAdapter(ListActivity.this, buildingArrayList);
                            binding.listview.setAdapter(listAdapter);
                            binding.listview.setClickable(true);
                            binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                    Intent i = new Intent(ListActivity.this,BuildingActivity.class);
                                    i.putExtra("name", buildingArrayList.get(position).getName());
                                    i.putExtra("risk", buildingArrayList.get(position).getRisk().toString());
                                    i.putExtra("code", buildingArrayList.get(position).getCode());
                                    startActivity(i);

                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        }










    }
