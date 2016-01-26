package com.example.aagam.note;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Aagam on 24-01-2016.
 */
public class SampleApplication extends Application{
    @Override
    public void onCreate(){

        Parse.initialize(this, "xCZkxJAECrzIstFxSYKYAQUHllOdGU1RcRIMefGR", "5uzD5OvR87TZDSvFtMfhvzfKsf5GsOVgPEefRGfn");
    }

}

