package com.example.atomica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.atomica.activities.AnalyzeActivity;
import com.example.atomica.activities.ChatBotActivity;
import com.example.atomica.activities.MediaAcitivity;
import com.example.atomica.activities.SearchActivity;
import com.example.atomica.activities.WebActivity;
import com.example.atomica.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    WebViewController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.bottom_analyze) {
                    goTo(AnalyzeActivity.class);
                    return true;
                } else if (id == R.id.bottom_bot) {
                    goTo(ChatBotActivity.class);
                    return true;
                } else if (id == R.id.bottom_media) {
                    goTo(MediaAcitivity.class);
                    return true;
                } else if (id == R.id.bottom_search) {
                    goTo(SearchActivity.class);
                    return true;
                } else if (id == R.id.bottom_table) {
                    goTo(WebActivity.class);
                    return true;
                }
                return false;
            }
        });

    }

    private void goTo(Class<? extends Activity> destination)
    {
        startActivity(new Intent(MainActivity.this,destination));
    }


}