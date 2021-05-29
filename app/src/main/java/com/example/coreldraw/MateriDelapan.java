package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriDelapan extends AppCompatActivity {

    PDFView pdf8;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_delapan);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf8 = (PDFView) findViewById(R.id.pdfmateri8);
        pdf8.fromAsset("Materi_8.pdf").load();
        pdf8.setMinZoom(0);
        pdf8.setMidZoom(0);
        pdf8.setMaxZoom(0);
        pdf8.fitToWidth(0);
        pdf8.enableDoubletap(false);
        pdf8.useBestQuality(true);
    }
}
