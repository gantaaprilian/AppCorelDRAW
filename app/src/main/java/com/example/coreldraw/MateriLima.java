package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriLima extends AppCompatActivity {

    PDFView pdf5;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_lima);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf5 = (PDFView) findViewById(R.id.pdfmateri5);
        pdf5.fromAsset("Materi_5.pdf").load();
        pdf5.setMinZoom(0);
        pdf5.setMidZoom(0);
        pdf5.setMaxZoom(0);
        pdf5.fitToWidth(0);
        pdf5.enableDoubletap(false);
        pdf5.useBestQuality(true);
    }
}
