package com.example.crimereport;

import android.widget.EditText;

public class UserInfo {

    // string variable for
    // storing employee name.
    private EditText user;

    // string variable for storing
    // employee contact number
    private EditText mobile;


    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public UserInfo() {

    }

    // created getter and setter methods
    // for all our variables.
    public EditText getUsername() {
        return user;
    }

    public void setUsername(EditText user) {
        this.user = user;
    }

    public EditText getMobile() {
        return mobile;
    }

    public void setMobile(EditText mobile) {
        this.mobile = mobile;
    }

}
