package com.example.ilwoof;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button logoutButton = (Button) findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String uuid = extras.get("user").toString();

        TextView welcome = findViewById(R.id.textView);
        ImageView userImage = findViewById(R.id.imageView);

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child(uuid).get().addOnCompleteListener(
            new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    Log.d("querying DB", "UUID: " + uuid);
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    }
                    else {
                        User user = task.getResult().getValue(User.class);
                        welcome.setText("Welcome " + user.nickname);
                        Glide.with(MenuActivity.this).load(Uri.parse(user.avatar)).into(userImage);
                    }
                }
            }
        );

        List<MenuOption> options = new ArrayList<>();
        options.add(new MenuOption(R.drawable.videos, "Videos", "see recommended videos", VideosActivity.class));
        options.add(new MenuOption(R.drawable.tutorials, "Tutorials", "Useful tutorials and guidelines", TutorialsActivity.class));
        options.add(new MenuOption(R.drawable.contact, "Contact us", "Let's be in touch!", ContactActivity.class));

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        MenuOptionsAdapter adapter = new MenuOptionsAdapter(options);
        recyclerView.setAdapter(adapter);
    }
}