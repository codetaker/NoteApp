package com.example.aagam.note;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.parse.ParseUser;


public class MainActivity extends AppCompatActivity {

    EditText note,remarks,days;
    ToggleButton tbtn;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);

        note=(EditText)findViewById(R.id.note);
        remarks=(EditText)findViewById(R.id.remarks);
        days=(EditText)findViewById(R.id.number);
        tbtn=(ToggleButton)findViewById(R.id.done);
        btn=(Button)findViewById(R.id.button);

    String test,objectid;
        final ParseUser currentuser=ParseUser.getCurrentUser();
        test=currentuser.getUsername().toString();
        objectid=currentuser.getObjectId();
        test="Welcome"+" "+test;
        TextView TextView_msg= (TextView) findViewById(R.id.textView_msg);
        TextView_msg.setText(test);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd=new ProgressDialog(MainActivity.this);
                pd.setTitle("Please wait...");
                pd.setMessage("Submitting In. Please Wait");
                pd.show();
                new Thread(new Runnable(){
                    public void run(){
                        try {
                            Thread.sleep(2500);
                            pd.dismiss();
                            finish();
                            startActivity(getIntent());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case  R.id.action_show:{
                String not,remark,num;
                Boolean toggle;
                not=note.getText().toString();
                remark=remarks.getText().toString();
                num=days.getText().toString();
                toggle=tbtn.isChecked();
                Bundle b = new Bundle();
                b.putString("note", not);
                b.putBoolean("done", toggle);
                b.putString("days", num);
                b.putString("remarks", remark);
                Intent i = new Intent(MainActivity.this,showActivity.class);
                i.putExtras(b);
                startActivity(i);
                break;
            }
            case  R.id.action_logout: {
                ParseUser.getCurrentUser().logOut();
                Intent myIntent = new Intent(MainActivity.this, DispatchActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
                startActivity(myIntent);
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


