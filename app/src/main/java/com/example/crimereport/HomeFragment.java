package com.example.crimereport;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.crimereport.services.AddContact;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment {

    Button log,reg,logout;
    Toolbar toolbar;
    CardView cardView1,cardView2;
    Button button1,button2,button22;

    FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container,false);

        log = (Button) view.findViewById(R.id.report_crime_img);
        reg = (Button) view.findViewById(R.id.unknown_accident_img);

        button1=view.findViewById(R.id.button1);
        button2=view.findViewById(R.id.button21);
        button22=view.findViewById(R.id.button22);

        logout=view.findViewById(R.id.logout);

        mAuth = FirebaseAuth.getInstance();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), AnonymousReport.class);
                startActivity(i1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), AnonymousReport.class);
                startActivity(i1);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(getActivity(), "You are being logged out", Toast.LENGTH_SHORT).show();
                Intent int1 = new Intent(getActivity(), LoginActivity.class);
                int1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);//makesure user cant go back
                startActivity(int1);
            }
        });

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), AnonymousReport.class);
                startActivity(i1);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAuth.getCurrentUser() != null) {
                    Toast.makeText(getActivity(), "You are already logged in", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i1 = new Intent(getActivity(), com.example.crimereport.LoginActivity.class);
                    startActivity(i1);
                }
            }

        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getActivity(),RegisterActivity.class);
                startActivity(i2);
            }
        });

        return view;
    }


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


}
