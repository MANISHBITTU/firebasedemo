package com.example.firebasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("Name");
        TextView text=findViewById(R.id.text);
         text.setText("Hello Mr. "+name);

    }
    public void callMainActivity(View view){

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
