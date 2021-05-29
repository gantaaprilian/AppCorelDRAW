package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriDua extends AppCompatActivity {

    PDFView pdf2;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_dua);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf2 = (PDFView) findViewById(R.id.pdfmateri2);
        pdf2.fromAsset("Materi_2.pdf").load();
        pdf2.setMinZoom(0);
        pdf2.setMidZoom(0);
        pdf2.setMaxZoom(0);
        pdf2.fitToWidth(0);
        pdf2.enableDoubletap(false);
        pdf2.useBestQuality(true);
    }
}
