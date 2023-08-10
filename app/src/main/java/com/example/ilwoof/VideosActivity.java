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

public class VideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button logoutButton = (Button) findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(VideosActivity.this, MainActivity.class));
            }
        });


        List<Link> links = new ArrayList<>();
        links.add(new Link(R.drawable.puppy, "Puppy sedation", "Some ways to calm your puppy", "https://www.youtube.com/watch?v=pq4gPoqeQq4"));
        links.add(new Link(R.drawable.training, "Dog training", "How to tire your dogs and at the same time keep them fitness", "https://www.youtube.com/watch?v=4ip0bdJ9fRM/"));
        links.add(new Link(R.drawable.thinkingames, "Thinking games", "Winning mind games to challenge your dog", "https://www.youtube.com/watch?v=7M_yBJRWkpY/"));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        LinksAdapter adapter = new LinksAdapter(links);
        recyclerView.setAdapter(adapter);
    }
}