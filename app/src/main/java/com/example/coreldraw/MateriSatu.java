package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriSatu extends AppCompatActivity {

    PDFView pdf1;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_satu);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf1 = (PDFView) findViewById(R.id.pdfmateri1);
        pdf1.fromAsset("Materi_1.pdf").load();
        pdf1.setMinZoom(0);
        pdf1.setMidZoom(0);
        pdf1.setMaxZoom(0);
        pdf1.fitToWidth(0);
        pdf1.enableDoubletap(false);
        pdf1.useBestQuality(true);
    }
}
