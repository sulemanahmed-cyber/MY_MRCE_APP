package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;

public class placements extends AppCompatActivity {
    public static Context context;
    //ImageView img_1;
    //WebView webView;
    //PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placements);
        WebView browser = (WebView) findViewById(R.id.wb1);
        browser.loadUrl("https://mrce.in/photogallery.html");

       /* webView = findViewById(R.id.webview);
         webView.getSettings().getJavaScriptEnabled();
        webView.loadUrl("http://www.mrce.in/contactus.html");*/
        context = getApplicationContext();
        //img_1 = (ImageView) findViewById(R.id.img_1);
        //pdfView=findViewById(R.id.pdf1);
        //pdfView.fromAsset("PLACEMENTS1.pdf").load();
        //Glide.with(placements.context).load("https://drive.google.com/drive/u/1/folders/1eieiAf9F1T2TkiOzFKB2bYobDNE3-pN9").into(img_1);


    }


}