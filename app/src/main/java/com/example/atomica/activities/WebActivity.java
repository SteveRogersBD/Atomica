package com.example.atomica.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.atomica.R;
import com.example.atomica.WebViewController;
import com.example.atomica.databinding.ActivityWebBinding;

public class WebActivity extends AppCompatActivity {

    ActivityWebBinding binding;
    WebViewController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        controller = new WebViewController();
        binding.web.loadUrl("https://graphoverflow.com/graphs/3d-periodic-table.html");
        binding.web.setWebViewClient(controller);
        setupWebView();

    }

    private void setupWebView() {
        // Enable JavaScript
        binding.web.getSettings().setJavaScriptEnabled(true);
        // Enable DOM storage (important for some dynamic websites)
        binding.web.getSettings().setDomStorageEnabled(true);
        // Enable viewport scaling and adjust page width
        binding.web.getSettings().setUseWideViewPort(true);
        binding.web.getSettings().setLoadWithOverviewMode(true);
        // Enable zoom support
        binding.web.getSettings().setSupportZoom(true);
        binding.web.getSettings().setBuiltInZoomControls(true);
        binding.web.getSettings().setDisplayZoomControls(false);
        // Enable scrolling
        binding.web.setHorizontalScrollBarEnabled(true);
        binding.web.setVerticalScrollBarEnabled(true);

        // Handle page errors (optional)
        binding.web.setWebViewClient(new WebViewController());
    }

    @Override
    public void onBackPressed() {
        if(binding.web.canGoBack())
        {
            binding.web.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}