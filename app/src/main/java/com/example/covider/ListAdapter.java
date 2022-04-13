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

        TextView risk = convertView.findViewById(R.id.risk);
        TextView name = convertView.findViewById(R.id.name);

        name.setText(building.getName());
        risk.setText(0);
        //risk.setText("Covid Risk: " + building.getRisk()+"%");


        return convertView;
    }
}