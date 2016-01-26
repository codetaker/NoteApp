package com.example.aagam.note;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.parse.ParseUser;

/**
 * Created by Aagam on 24-01-2016.
 */
public class DispatchActivity extends Activity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(ParseUser.getCurrentUser()!=null)
            startActivity(new Intent(this,MainActivity.class));
        else
            startActivity(new Intent(this,SignUporLoginActivity.class));
    }
}
