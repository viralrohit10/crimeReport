package com.example.crimereport.services;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crimereport.R;
import com.example.crimereport.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddContact extends AppCompatActivity {

    EditText c1,c2,c3,c4,c5;
    Button savec;

    // creating a variable for our
    // Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for
    // our object class
    UserInfo userInfo;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        getSupportActionBar().setTitle("Add Contacts");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);
        c5=findViewById(R.id.c5);

        savec=findViewById(R.id.savec);

        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("UserInfo");

        // initializing our object
        // class variable.
        userInfo = new UserInfo();


        savec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dc1 = c1.getText().toString();
                String dc2 = c2.getText().toString();
                String dc3 = c3.getText().toString();
                String dc4 = c4.getText().toString();
                String dc5 = c5.getText().toString();

                // below line is for checking weather the
                // edittext fields are empty or not.
                if (TextUtils.isEmpty(dc1)) {
                    // if the text fields are empty
                    // then show the below message.
                    Toast.makeText(AddContact.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {
                    // else call the method to add
                    // data to our database.
                    addDatatoFirebase(dc1, dc2, dc3,dc4,dc5);
                }
            }
        });

    }

    private void addDatatoFirebase(String dc1, String dc2, String dc3, String dc4, String dc5) {

        userInfo.setC1(dc1);
        userInfo.setC2(dc2);
        userInfo.setC3(dc3);
        userInfo.setC4(dc4);
        userInfo.setC5(dc5);

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // inside the method of on Data change we are setting
                // our object class to our database reference.
                // data base reference will sends data to firebase.
                databaseReference.setValue(userInfo);

                // after adding this data we are showing toast message.
                Toast.makeText(AddContact.this, "Data added successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // if the data is not added or it is cancelled then
                // we are displaying a failure toast message.
                Toast.makeText(AddContact.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });

    }


}