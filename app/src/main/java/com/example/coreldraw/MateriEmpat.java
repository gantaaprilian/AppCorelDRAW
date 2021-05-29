package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriEmpat extends AppCompatActivity {

    PDFView pdf4;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_empat);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf4 = (PDFView) findViewById(R.id.pdfmateri4);
        pdf4.fromAsset("Materi_4.pdf").load();
        pdf4.setMinZoom(0);
        pdf4.setMidZoom(0);
        pdf4.setMaxZoom(0);
        pdf4.fitToWidth(0);
        pdf4.enableDoubletap(false);
        pdf4.useBestQuality(true);
    }
}
