package com.example.crimereport;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileFragment extends Fragment {


    Button button;
    EditText user,pass;
    TextView register;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile,container,false);

        user=view.findViewById(R.id.user);
        pass=view.findViewById(R.id.pass);
        button=view.findViewById(R.id.report_crime_img);
        register=view.findViewById(R.id.textReg);

        //  ((AppCompatActivity) getActivity()).getSupportActionBar().hide();




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),RegisterActivity.class);
                startActivity(i);
            }
        });

        return view;
    }

    /*

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }
    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }


     */

}
