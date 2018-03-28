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

import model.User;

public class SecReg extends AppCompatActivity {

    Button nextB, backB;
    private String regFname, regLname, regUsername, regPassword, regConfirmPass;
    private EditText regHeight;
    private EditText regWeight;
    private EditText regMin;
    private EditText regMax;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference dbr = db.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_reg);

        //To get data from prev. page
        // Intent is like a session
        Intent intent = getIntent();

        regFname = intent.getStringExtra("regFname");
        regLname = intent.getStringExtra("regLname");
        regUsername = intent.getStringExtra("regUsername");
        regPassword = intent.getStringExtra("regPassword");
        regConfirmPass = intent.getStringExtra("regConfirmPass");

        regHeight = (EditText)findViewById(R.id.regHeight);
        regWeight = (EditText)findViewById(R.id.regWeight);
        regMin =(EditText)findViewById(R.id.regMin);
        regMax = (EditText)findViewById(R.id.regMax);

        nextB = (Button) findViewById(R.id.b_create);
        backB = (Button) findViewById(R.id.b_back);

        nextB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!regHeight.getText().toString().isEmpty()&&
                   !regWeight.getText().toString().isEmpty()&&
                   !regMax.getText().toString().isEmpty()&&
                   !regMin.getText().toString().isEmpty()&&
                   !regFname.isEmpty()) {

                    User user1 = new User(regUsername, regFname, regLname, regPassword, regHeight.getText().toString(), regWeight.getText().toString(), regMax.getText().toString(), regMin.getText().toString());
                    dbr.child("users").child(regUsername).setValue(user1);
                    Intent welcomePage = new Intent(SecReg.this, WelcomePage.class);
                    welcomePage.putExtra("username", regUsername);

                    Toast.makeText(SecReg.this,
                            "Successfully registered!", Toast.LENGTH_LONG).show();

                    startActivity(welcomePage);
                }
                else
                    Toast.makeText(SecReg.this, "Please fill in the blank", Toast.LENGTH_SHORT).show();



            }
        });
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backPage = new Intent(SecReg.this, ActivityRegister.class);
                startActivity(backPage);
            }
        });


    }
}
