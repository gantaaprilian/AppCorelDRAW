package com.example.coreldraw;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class Materi extends AppCompatActivity {

    CardView materi1, materi2, materi3, materi4, materi5, materi6, materi7, materi8, materi9;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        this.setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        materi1 = (CardView) findViewById(R.id.cardMateri1);
        materi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriSatu.class);
                startActivity(intent);
            }
        });

        materi2 = (CardView) findViewById(R.id.cardMateri2);
        materi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriDua.class);
                startActivity(intent);
            }
        });

        materi3 = (CardView) findViewById(R.id.cardMateri3);
        materi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriTiga.class);
                startActivity(intent);
            }
        });

        materi4 = (CardView) findViewById(R.id.cardMateri4);
        materi4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriEmpat.class);
                startActivity(intent);
            }
        });

        materi5 = (CardView) findViewById(R.id.cardMateri5);
        materi5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriLima.class);
                startActivity(intent);
            }
        });

        materi6 = (CardView) findViewById(R.id.cardMateri6);
        materi6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriEnam.class);
                startActivity(intent);
            }
        });

        materi7 = (CardView) findViewById(R.id.cardMateri7);
        materi7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriTujuh.class);
                startActivity(intent);
            }
        });

        materi8 = (CardView) findViewById(R.id.cardMateri8);
        materi8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriDelapan.class);
                startActivity(intent);
            }
        });

        materi9 = (CardView) findViewById(R.id.cardMateri9);
        materi9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Materi.this, MateriSembilan.class);
                startActivity(intent);
            }
        });
    }
}
