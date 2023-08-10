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

public class TutorialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button logoutButton = (Button) findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(TutorialsActivity.this, MainActivity.class));
            }
        });

        List<Link> links = new ArrayList<>();
        links.add(new Link(R.drawable.kids, "Tips for puppies", "Training puppies to stop destroying", "http://www.dogs-dogs.co.il/%d7%97%d7%99%d7%a0%d7%95%d7%9a-%d7%92%d7%95%d7%a8-%d7%9c%d7%90-%d7%9c%d7%94%d7%a8%d7%95%d7%a1/"));
        links.add(new Link(R.drawable.destroying, "Dogs and kids", "How to get the dog used to the children's presence ", "http://www.dogs-dogs.co.il/%d7%9b%d7%9c%d7%91%d7%99%d7%9d-%d7%95%d7%99%d7%9c%d7%93%d7%99%d7%9d-dogs-dogs/"));
        links.add(new Link(R.drawable.trainingsteps, "How to train a dog", "Sept for dog's training", "http://www.dogs-dogs.co.il/%d7%90%d7%99%d7%9a-%d7%9e%d7%90%d7%9c%d7%a4%d7%99%d7%9d-%d7%9b%d7%9c%d7%91/"));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        LinksAdapter adapter = new LinksAdapter(links);
        recyclerView.setAdapter(adapter);
    }
}