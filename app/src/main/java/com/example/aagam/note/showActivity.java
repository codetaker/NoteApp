package com.example.aagam.note;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class showActivity extends AppCompatActivity {

    String str1,str2,str3,str4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_show);

        Intent i=getIntent();
        Bundle extras=i.getExtras();
        String note=extras.getString("note");
        Boolean done=extras.getBoolean("done");
        String num=extras.getString("days");
        String remarks=extras.getString("remarks");

        str1="Note : "+note;
        str2="Done : "+done;
        str3="Days : "+num;
        str4="remarks : "+remarks;

        TextView txt1=(TextView)findViewById(R.id.textView1);
        TextView txt2=(TextView)findViewById(R.id.textView2);
        TextView txt3=(TextView)findViewById(R.id.textView3);
        TextView txt4=(TextView)findViewById(R.id.textView4);
        txt1.setText(str1);
        txt2.setText(str2);
        txt3.setText(str3);
        txt4.setText(str4);
    }

}
