package com.uweeldteam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.uweeldteam.databinding.ActivityMainMenuBinding;

public class MainMenuActivity extends Activity {
    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.uweeldteam.databinding.ActivityMainMenuBinding binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        start = findViewById(R.id.start);
        start.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenuActivity.this, GameActivity.class);
            startActivity(intent);
        });
    }
}