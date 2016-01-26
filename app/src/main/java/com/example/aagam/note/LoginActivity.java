package com.example.aagam.note;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Aagam on 24-01-2016.
 */
public class LoginActivity extends Activity {
    private EditText user,pass;
    private TextView txt;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        txt  = (TextView) findViewById(R.id.error_messages);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String test1=user.getText().toString();
                String test2=pass.getText().toString();if((test1==""||test1.trim().length()==0||test1==null)&&(test2==""||test2.trim().length()==0||test2==null))
                    txt.setText("Kindly Enter username and password");
                else if(test1==""||test1.trim().length()==0||test1==null)
                    txt.setText("Kindly Enter username");
                else if(test2==""||test2.trim().length()==0||test2==null)
                    txt.setText("Kindly Enter password");
                else{

                //Dialog
                final ProgressDialog pd=new ProgressDialog(LoginActivity.this);
                pd.setTitle("Please wait...");
                pd.setMessage("Logging In. Please Wait");
                pd.show();
                ParseUser.logInInBackground(user.getText().toString(), pass.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        pd.dismiss();
                        if(e!=null)
                            Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        else {
                            Intent intent=new Intent(LoginActivity.this,DispatchActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    }
                });
            }
            }
        });
    }

}
