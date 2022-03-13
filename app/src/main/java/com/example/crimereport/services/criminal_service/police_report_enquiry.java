package com.example.crimereport.services.criminal_service;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.crimereport.R;

public class police_report_enquiry extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_report_enquiry);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Police Report Enquiry");


    }
}