package com.example.atomica.fragments;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.atomica.R;
import com.example.atomica.WebViewController;
import com.example.atomica.databinding.FragmentWebBinding;

public class WebFragment extends Fragment {


    public WebFragment() {
        // Required empty public constructor
    }

    WebViewController controller;
    FragmentWebBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWebBinding.inflate(inflater,container,false);
        controller = new WebViewController();
        binding.web.loadUrl("https://graphoverflow.com/graphs/3d-periodic-table.html");
        binding.web.setWebViewClient(controller);
        setupWebView();

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(binding.web.canGoBack())
                {
                    binding.web.goBack();
                }
                else{
                    requireActivity().getSupportFragmentManager().popBackStack();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
        return binding.getRoot();
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

    }





}