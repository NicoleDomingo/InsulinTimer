package com.example.asus.insulintimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ActivityRegister extends AppCompatActivity {
    Button nextB,loginB;

    private EditText regFname;
    private EditText regLname;
    private EditText regUsername;
    private EditText regPassword;
    private EditText regConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nextB = (Button) findViewById(R.id.b_create);
        loginB = (Button) findViewById(R.id.b_loginreg);


        regFname = (EditText) findViewById(R.id.regFname);
        regLname = (EditText) findViewById (R.id.regLname);
        regUsername = (EditText) findViewById(R.id.regUsername);
        regPassword = (EditText) findViewById(R.id.regPassword);
        regConfirmPass = (EditText) findViewById(R.id.regConfirmPass);

        nextB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String pass1 = regPassword.getText().toString();
                    String pass2 = regConfirmPass.getText().toString();
                if(!regFname.getText().toString().isEmpty()&&
                   !regLname.getText().toString().isEmpty()&&
                   !regPassword.toString().isEmpty()&&
                   !regConfirmPass.getText().toString().isEmpty()){

                    if(pass1.equals(pass2)) {

                        // To save the data until the next page
                        Intent nextPage = new Intent(ActivityRegister.this, SecReg.class);
                        nextPage.putExtra("regFname", regFname.getText().toString());
                        nextPage.putExtra("regLname", regLname.getText().toString());
                        nextPage.putExtra("regUsername", regUsername.getText().toString());
                        nextPage.putExtra("regPassword", regPassword.getText().toString());
                        nextPage.putExtra("regConfirmPass", regConfirmPass.getText().toString());

                        startActivity(nextPage);

                    }else if(!pass1.equals(pass2)){
                        Toast.makeText(ActivityRegister.this,
                                "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ActivityRegister.this,
                            "Fill up required fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backPage = new Intent(ActivityRegister.this, ActivityLogin.class );
                startActivity(backPage);
            }
        });
    }
}
