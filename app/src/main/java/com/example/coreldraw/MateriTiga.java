package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriTiga extends AppCompatActivity {

    PDFView pdf3;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_tiga);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf3 = (PDFView) findViewById(R.id.pdfmateri3);
        pdf3.fromAsset("Materi_3.pdf").load();
        pdf3.setMinZoom(0);
        pdf3.setMidZoom(0);
        pdf3.setMaxZoom(0);
        pdf3.fitToWidth(0);
        pdf3.enableDoubletap(false);
        pdf3.useBestQuality(true);
    }
}
