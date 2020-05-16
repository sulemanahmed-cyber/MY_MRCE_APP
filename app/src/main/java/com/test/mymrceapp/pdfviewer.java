package com.test.mymrceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class pdfviewer extends AppCompatActivity {
    PDFView pdfView;
    Integer s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfviewer);
 /*      Intent I = getIntent();
        s=I.getIntExtra("key",0);
        pdfView=findViewById(R.id.pdfview);
        pdfView.fitToWidth();
        pdfView.getMaxZoom();
        pdfView.getOptimalPageWidth();

        if(s==112) {
            pdfView.fromAsset("1styear.pdf").load();

        }*/
    }
}
