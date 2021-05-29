package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriEnam extends AppCompatActivity {

    PDFView pdf6;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_enam);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf6 = (PDFView) findViewById(R.id.pdfmateri6);
        pdf6.fromAsset("Materi_6.pdf").load();
        pdf6.setMinZoom(0);
        pdf6.setMidZoom(0);
        pdf6.setMaxZoom(0);
        pdf6.fitToWidth(0);
        pdf6.enableDoubletap(false);
        pdf6.useBestQuality(true);
    }
}
