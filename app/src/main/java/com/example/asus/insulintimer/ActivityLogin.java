package com.example.asus.insulintimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityLogin extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();
    private DatabaseReference userDataReference;

    private EditText username;
    private EditText password;

    Button loginB, signupB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        loginB = (Button) findViewById(R.id.b_proceed);
        signupB = (Button) findViewById(R.id.b_register);

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty() ) {
                    userDataReference = databaseReference.child("users");
                    userDataReference.orderByChild("username").equalTo(username.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                userDataReference = databaseReference; //orderByChild("password").equalTo(password.getText().toString()).
                                userDataReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        if (dataSnapshot.exists()) {
                                            // ArrayList<String> stringtmep = aosjbfjhafs
                                            for (DataSnapshot childRow : dataSnapshot.getChildren()) {

                                            }

                                            Intent loginIntent = new Intent(ActivityLogin.this, MainActivity.class);
                                            loginIntent.putExtra("username", username.getText().toString());
                                            startActivity(loginIntent);
                                        } else {
                                            Toast.makeText(ActivityLogin.this, "The Password does not exist", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {

                                    }
                                });
                            } else {
                                Toast.makeText(ActivityLogin.this, "The username does not exist", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }else{
                    Toast.makeText(ActivityLogin.this,
                            "Please fill in the blanks", Toast.LENGTH_SHORT).show();
                }


            }
        });

        signupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent (ActivityLogin.this, ActivityRegister.class);
                startActivity(signupIntent);
            }
        });

    }
}
