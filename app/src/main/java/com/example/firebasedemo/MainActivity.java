package com.example.firebasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText name, fname;
    private Button button1, button2;
    private FirebaseDatabase database;
    private RecyclerView recyclerView;
    DatabaseReference myRef;
    ArrayList<Info> list;
    ProgramingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();


    }

    public void addListenerOnButton() {
        name = (EditText) findViewById(R.id.name);
        fname = (EditText) findViewById(R.id.fathername);
        button1 = (Button) findViewById(R.id.submit);
        button2 = (Button) findViewById(R.id.show);
        list = new ArrayList<Info>();
        recyclerView = findViewById(R.id.recycle);
        database = FirebaseDatabase.getInstance();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = name.getText().toString();
                String value2 = fname.getText().toString();


                myRef = database.getReference().child("Profile");
                String id = myRef.push().getKey();
                Info info = new Info(id, value1, value2);
                myRef.child(id).setValue(info);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myRef = database.getReference().child("Profile");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                            Info p = dataSnapshot1.getValue(Info.class);

                            Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();

                            list.add(p);
                        }
                        adapter = new ProgramingAdapter(list);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}

