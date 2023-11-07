package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MissionAndVission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_and_vission);
        Intent MissionAndVision = getIntent() ;
        MissionAndVision.getStringExtra("Terms");
        String message = MissionAndVision.getStringExtra("Terms");
        TextView textview = (TextView) findViewById(R.id.PassedMessageFromDifferentActivity);
        textview.setText(message);
    }
}