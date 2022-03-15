package com.example.crimereport.services.save_people;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.crimereport.LoginActivity;
import com.example.crimereport.R;
import com.example.crimereport.services.AddContact;

import java.util.zip.Inflater;


public class sos extends AppCompatActivity {

    private Object ServicesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Intent intent=new Intent(sos.this, AddContact.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                showhelp();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showhelp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(sos.this);
        builder.setTitle("SEND SMS");
        builder.setMessage("This option let you send instant SMS to your friends,family and near ones at the time emergency. " +
                "1. Add contacts of your choice. " +
                "2. Push SOS button to send auto generated SMS.");

        //Cancel Button
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}

