package com.example.crimereport;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.crimereport.services.criminal_service.Report_crime;
import com.example.crimereport.services.criminal_service.info_provide;
import com.example.crimereport.services.criminal_service.police_report_enquiry;
import com.example.crimereport.services.save_people.Trafic_accident;
import com.example.crimereport.services.save_people.UnknownAccident;
import com.example.crimereport.services.save_people.Victim_support;
import com.example.crimereport.services.save_people.sos;
import com.example.crimereport.services.traffic_service.fine_payment;

import java.sql.Ref;

public class ServicesFragment extends Fragment {

    CardView sos_card,traffic_accident_card,unknown_accident_card,victim_support_card;
    CardView fine_pay_card,view_receipt_card;
    CardView report_crime_card,info_provide_card,report_enquiry_card;
    CardView police_report_enquiry;
    ImageView img;

    Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_services,container,false);
      //  ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Services");


        sos_card = (CardView) view.findViewById(R.id.sos_card);
        traffic_accident_card=view.findViewById(R.id.traffic_accident_card);
        unknown_accident_card=view.findViewById(R.id.unknown_accident_card);
        victim_support_card=view.findViewById(R.id.victim_support_card);
        fine_pay_card=view.findViewById(R.id.fine_pay_card);
        view_receipt_card=view.findViewById(R.id.View_receipt_card);
        report_crime_card=view.findViewById(R.id.report_crime_card);
        info_provide_card=view.findViewById(R.id.info_provide_card);
        report_enquiry_card=view.findViewById(R.id.report_enquiry_card);

        img=view.findViewById(R.id.sosimg);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), sos.class);
                getActivity().startActivity(intent2);
            }
        });

        sos_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), sos.class);
                getActivity().startActivity(intent);
            }
        });

        traffic_accident_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Trafic_accident.class);
                getActivity().startActivity(intent);
            }
        });

        unknown_accident_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UnknownAccident.class);
                getActivity().startActivity(intent);
            }
        });

        victim_support_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Victim_support.class);
                getActivity().startActivity(intent);
            }
        });

        fine_pay_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), fine_payment.class);
                getActivity().startActivity(intent);
            }
        });

        view_receipt_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), sos.class);
                getActivity().startActivity(intent);
            }
        });

        report_crime_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Report_crime.class);
                getActivity().startActivity(intent);
            }
        });

        info_provide_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), info_provide.class);
                getActivity().startActivity(intent);
            }
        });

        report_enquiry_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),police_report_enquiry.class);
                getActivity().startActivity(intent);
            }
        });

        return view;

    }






    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.itemdetail, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item2:
                break;


        }
        return true;
    }




}