package com.example.aagam.note;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by Aagam on 24-01-2016.
 */
public class SignUpActivity extends Activity {
    EditText users,pass;
    TextView txt;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        users=(EditText) findViewById(R.id.username);
        pass=(EditText) findViewById(R.id.password);
        txt=(TextView) findViewById(R.id.error_messages);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String test1=users.getText().toString();
                String test2=pass.getText().toString();
                if((test1==""||test1.trim().length()==0||test1==null)&&(test2==""||test2.trim().length()==0||test2==null))
                    txt.setText("Kindly Enter username and password");
                else if(test1==""||test1.trim().length()==0||test1==null)
                    txt.setText("Kindly Enter username");
                else if(test2==""||test2.trim().length()==0||test2==null)
                    txt.setText("Kindly Enter password");
                else if(test2.trim().length()<6)
                    Toast.makeText(getApplicationContext(),"Password should have 6 or more characters",Toast.LENGTH_LONG).show();
                else {

                    final ProgressDialog pd = new ProgressDialog(SignUpActivity.this);
                    pd.setTitle("Please wait...");
                    pd.setMessage("Signing Up. Please Wait");
                    pd.show();

                    //Set up parse user
                    ParseUser user = new ParseUser();
                    user.setUsername(users.getText().toString());
                    user.setPassword(pass.getText().toString());

                    //Sign Up
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            pd.dismiss();
                            if (e != null)
                                Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            else {
                                Intent intent = new Intent(SignUpActivity.this, DispatchActivity.class);
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
