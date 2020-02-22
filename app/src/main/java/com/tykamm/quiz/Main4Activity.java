package com.tykamm.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    RelativeLayout layout;
    Switch dayNightMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        layout=findViewById(R.id.relative_layout1);
        dayNightMode=findViewById(R.id.daynightMode);
        dayNightMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layout.setBackgroundColor(getResources().getColor(R.color.nightBackground));
                }
                else {
                    layout.setBackgroundColor(getResources().getColor(R.color.dayBackground));
                }
            }
        });

    }
}
