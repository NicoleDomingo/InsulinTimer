package com.example.asus.insulintimer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomePage extends AppCompatActivity {

    private Button proceedB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        proceedB = (Button) findViewById(R.id.b_proceed);
        proceedB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proceed = new Intent(WelcomePage.this, MainActivity.class);
                startActivity(proceed);
            }
        });
    }
}
