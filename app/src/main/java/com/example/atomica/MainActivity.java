package com.example.atomica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.atomica.databinding.ActivityMainBinding;
import com.example.atomica.fragments.AnalyzeFragment;
import com.example.atomica.fragments.BotFragment;
import com.example.atomica.fragments.HomeFragment;
import com.example.atomica.fragments.SearchFragment;
import com.example.atomica.fragments.WebFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadFragment(new HomeFragment());


        binding.bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Define the selectedFragment variable here
                Fragment selectedFragment = null;

                int id = item.getItemId();
                if (id == R.id.bottom_analyze) {
                    selectedFragment = new AnalyzeFragment(); // Replace with your actual fragment
                } else if (id == R.id.bottom_bot) {
                    selectedFragment = new BotFragment(); // Replace with your actual fragment
                } else if (id == R.id.bottom_home) {
                    selectedFragment = new HomeFragment();
                } else if (id == R.id.bottom_search) {
                    selectedFragment = new SearchFragment(); // Replace with your actual fragment
                } else if (id == R.id.bottom_table) {
                    selectedFragment = new WebFragment(); // Replace with your actual fragment
                }

                // Pass selectedFragment to the loadFragment method
                return loadFragment(selectedFragment);
            }
        });
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(binding.frameFragment.getId(), fragment)  // Ensure this matches your ID
                    .commit();
            return true;
        }
        return false;
    }





}