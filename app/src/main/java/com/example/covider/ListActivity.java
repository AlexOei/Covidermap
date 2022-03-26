package com.example.covider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;


import com.example.covider.databinding.ActivityListBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListActivity extends AppCompatActivity {
    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListActivity.class);
                startActivity(i);
            }
        });
        ArrayList<Building> buildingArrayList = new ArrayList<>();
        String[] latitude = {"34", "33"};
        String[] longitude = {"110", "105"};
        String[] title = {"salvatori", "zumberge"};
        String[] code = {"SAL", "ZHS"};
        String[] name = {"name1", "name2"};
        for(int i = 0;i< 2;i++){

            Building build = new Building(latitude[i], longitude[i], title[i], code[i], name[i]);
            buildingArrayList.add(build);

        }

        ListAdapter listAdapter = new ListAdapter(ListActivity.this,buildingArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ListActivity.this,BuildingActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",title[position]);
                i.putExtra("code",code[position]);
                startActivity(i);

            }
        });

    }
}