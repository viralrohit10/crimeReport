package com.example.crimereport.services.save_people;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.crimereport.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

public class UnknownAccident extends AppCompatActivity {

    // Define the pic id
    private static final int pic_id = 123;
    private static final int pic_id2 = 1;
    private static final int SELECT_IMAGE = 12;

    // Define the button and imageview type variable
    FloatingActionButton fabcamera,fabaudio,fabvideo,fabgallery;
    ImageView click_image_id;
    ImageView click_image_id2;



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unknown_accident);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Unknown Accident Report");

        fabcamera = (FloatingActionButton) findViewById(R.id.fabcamera);
      //  fabaudio = (FloatingActionButton) findViewById(R.id.fabaudio);
        fabvideo = (FloatingActionButton) findViewById(R.id.fabvideo);
        fabgallery = (FloatingActionButton) findViewById(R.id.fabgallary);

        click_image_id = (ImageView)findViewById(R.id.cimage);

        fabcamera.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);
            }
        });

        fabvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(intent, pic_id2);
            }
        });

        fabgallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Select Image From Gallery
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_IMAGE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            click_image_id.setImageBitmap(photo);
        }

        if (requestCode == SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                        click_image_id.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED)  {
                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_SHORT).show();
            }
        }

    }

}