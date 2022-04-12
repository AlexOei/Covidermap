package com.example.covider;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MapsLogic {

    public void setButton(Button button, Class context){
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(view.getContext(), context);
                view.getContext().startActivity(i);
            }
        });
    }


}
