package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class MateriSembilan extends AppCompatActivity {

    PDFView pdf9;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_sembilan);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        pdf9 = (PDFView) findViewById(R.id.pdfmateri9);
        pdf9.fromAsset("Materi_9.pdf").load();
        pdf9.setMinZoom(0);
        pdf9.setMidZoom(0);
        pdf9.setMaxZoom(0);
        pdf9.fitToWidth(0);
        pdf9.enableDoubletap(false);
        pdf9.useBestQuality(true);
    }
}
