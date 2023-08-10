package com.example.ilwoof;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button logoutButton = (Button) findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(ContactActivity.this, MainActivity.class));
            }
        });


        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(R.drawable.yohai, "Yohai", "yohai.s@gmail.com"));
        contacts.add(new Contact(R.drawable.danielle, "Danielle", "danielle.b@gmail.com"));
        contacts.add(new Contact(R.drawable.ziv, "Ziv", "ziv.m@gmail.com"));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        ContactAdapter adapter = new ContactAdapter(contacts);
        recyclerView.setAdapter(adapter);
    }
}