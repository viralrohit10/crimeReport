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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

public class HomeFragment extends Fragment {

    Button log,reg;
    Toolbar toolbar;
    CardView cardView1,cardView2;
    Button button1,button2,button22;

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

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), AnonymousReport.class);
                startActivity(i1);
            }
        });
     //   cardView1= (CardView) view.findViewById(R.id.newscard1);
      //  cardView2= (CardView) view.findViewById(R.id.newscard2);


      /* cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getActivity(), MediaFragment.class);
                startActivity(i1);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getActivity(),MediaFragment.class);
                startActivity(ii);
            }
        });


       */
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getActivity(), com.example.crimereport.LoginActivity.class);
                startActivity(i1);
            }
      /*      @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("You are ? ");
                alertDialog.setInverseBackgroundForced(true);
                String[] items = {"Admin","User"};
                int checkedItem = 1;
                alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                Intent i1 = new Intent(getActivity(), LoginActivity.class);
                                startActivity(i1);
                                break;
                            case 1:
                                Intent i2 = new Intent(getActivity(), LoginActivity.class);
                                startActivity(i2);
                                break;
                        }
                    }
                });
                AlertDialog alert = alertDialog.create();
                alert.setCanceledOnTouchOutside(false);
                alert.show();
            }

       */

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
