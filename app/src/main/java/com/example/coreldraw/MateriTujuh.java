package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriTujuh extends AppCompatActivity {

    PDFView pdf7;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_tujuh);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf7 = (PDFView) findViewById(R.id.pdfmateri7);
        pdf7.fromAsset("Materi_7.pdf").load();
        pdf7.setMinZoom(0);
        pdf7.setMidZoom(0);
        pdf7.setMaxZoom(0);
        pdf7.fitToWidth(0);
        pdf7.enableDoubletap(false);
        pdf7.useBestQuality(true);
    }
}
