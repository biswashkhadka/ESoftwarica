package com.biswash.esoftwarica.ui.about;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.biswash.esoftwarica.R;


public class AboutFragment extends Fragment {

    private AboutModel aboutModel;
    private WebView webview;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        aboutModel = ViewModelProviders.of(this).get(AboutModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);

        webview=root.findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        //ebview.setWebViewClient(new WebViewClient());
        webview.loadUrl("https://softwarica.edu.np/");
        return root;
    }

}
