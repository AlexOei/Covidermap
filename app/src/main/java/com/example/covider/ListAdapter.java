package com.example.covider;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Building>{

    public ListAdapter(Context context, ArrayList<Building> buildingArrayList){

        super(context,R.layout.list_building,buildingArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Building building = getItem(position);

        if (convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_building,parent,false);

        }
        FloatingActionButton fab = (FloatingActionButton) convertView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Context con = view.getContext();
                Intent i = new Intent(con, MapsActivity.class);
                con.startActivity(i);
            }
        });
        TextView title = convertView.findViewById(R.id.title);
        TextView code = convertView.findViewById(R.id.code);
        TextView name = convertView.findViewById(R.id.name);

        title.setText(building.getTitle());
        code.setText(building.getCode());
        name.setText(building.getName());


        return convertView;
    }
}